package com.example.albums

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.albums.ui.pantallas.pantalla_detalle.DetailScreen
import com.example.albums.ui.pantallas.consulta_pantalla.QueryViewModel
import com.example.albums.ui.pantallas.pantalla_menu.MenuScreen
import com.example.albums.ui.pantallas.pantalla_detalle.DetailsViewModel
import com.example.bookshelf.ui.screens.query_screen.QueryScreen

@Composable
fun BookshelfNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel : QueryViewModel = viewModel(factory = QueryViewModel.Factory)

    NavHost(
        navController = navController,
        startDestination = AppDestinations.MenuScreen.name,
        modifier = modifier
    ) {

        composable(route = AppDestinations.MenuScreen.name) {
            MenuScreen(
                onSearchClick = {
                    navController.navigate(AppDestinations.QueryScreen.name)
                },
            )
        }

        composable(route = AppDestinations.QueryScreen.name) {
            QueryScreen(
                viewModel = viewModel,
                retryAction = { viewModel.getAlbums() },
                onDetailsClick = {
                    viewModel.selectedAlbumId = it.id
                    navController.navigate(AppDestinations.DetailScreen.name)
                },
            )
        }

        composable(route = AppDestinations.DetailScreen.name) {
            val detailViewModel : DetailsViewModel = viewModel(factory = DetailsViewModel.Factory)
            detailViewModel.getAlbum(viewModel.selectedAlbumId)

            DetailScreen(
                viewModel = detailViewModel,
                retryAction = { detailViewModel.getAlbum(viewModel.selectedAlbumId) },
            )
        }
    }
}
