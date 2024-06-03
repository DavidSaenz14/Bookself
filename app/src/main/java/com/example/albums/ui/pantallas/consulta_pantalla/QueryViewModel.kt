package com.example.albums.ui.pantallas.consulta_pantalla

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.albums.data.AlbumRepository
import com.example.albums.AlbumApplication
import com.example.albums.model.Album
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class QueryViewModel(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<QueryUiState>(QueryUiState.Loading)
    val uiState = _uiState.asStateFlow()

    var selectedAlbumId by mutableStateOf("")
    var albumList by mutableStateOf<List<Album>>(emptyList())
        private set

    private val _uiStateSearch = MutableStateFlow(SearchUiState())
    val uiStateSearch = _uiStateSearch.asStateFlow()

    fun updateQuery(query: String) {
        _uiStateSearch.update { currentState ->
            currentState.copy(
                query = query
            )
        }
    }

    fun updateSearchStarted(searchStarted: Boolean) {
        _uiStateSearch.update { currentState ->
            currentState.copy(
                searchStarted = searchStarted
            )
        }
    }

    fun getAlbums(query: String = "") {
        updateSearchStarted(true)
        viewModelScope.launch {
            _uiState.value = QueryUiState.Loading

            _uiState.value = try {
                val albums = albumRepository.getAlbums(query)
                albumList = albums ?: emptyList()
                if (albums == null) {
                    QueryUiState.Error
                } else if (albums.isEmpty()) {
                    QueryUiState.Success(emptyList())
                } else {
                    QueryUiState.Success(albums)
                }
            } catch (e: IOException) {
                QueryUiState.Error
            } catch (e: HttpException) {
                QueryUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AlbumApplication)
                val albumRepository = application.container.albumRepository
                QueryViewModel(albumRepository = albumRepository)
            }
        }
    }
}
