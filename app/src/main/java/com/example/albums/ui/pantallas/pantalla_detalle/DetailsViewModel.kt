package com.example.albums.ui.pantallas.pantalla_detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.albums.AlbumApplication
import com.example.albums.data.AlbumRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class DetailsViewModel(
    private val albumRepository: AlbumRepository
): ViewModel() {
    private val _uiStateDetail = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiStateDetail = _uiStateDetail.asStateFlow()


    fun getAlbum(id: String) {
        viewModelScope.launch {
            _uiStateDetail.value = try {
                val album = albumRepository.getAlbum(id)
                if (album == null) {
                    DetailsUiState.Error
                } else{
                    DetailsUiState.Success(album)
                }
            } catch (e: IOException) {
                DetailsUiState.Error
            } catch (e: HttpException) {
                DetailsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AlbumApplication)
                val albumRepository = application.container.albumRepository
                DetailsViewModel(albumRepository = albumRepository)
            }
        }
    }
}