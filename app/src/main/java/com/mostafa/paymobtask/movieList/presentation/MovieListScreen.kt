package com.mostafa.paymobtask.movieList.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.mostafa.paymobtask.core.presentation.HomeAnimatedShimmer
import com.mostafa.paymobtask.core.presentation.navigation.MOVIE_DETAILS
import com.mostafa.paymobtask.core.utils.ComposableLifecycle
import com.mostafa.paymobtask.core.utils.Logger
import com.mostafa.paymobtask.movieList.presentation.componants.MovieCard


@Composable
fun MovieListScreen(
    navController: NavController,
) {
    val viewModel = hiltViewModel<MovieListViewModel>()
    ComposableLifecycle { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            viewModel.onEvent(MovieListEvent.LoadMovieList)
        }
    }

    val state = viewModel.movieListState.collectAsState().value
    val movieList = state.movieList?.results

    Logger.i("MOVIE LIST ${state.movieList}")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        HomeAnimatedShimmer(showShimmer = state.isLoading)
        if (!state.isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn {
                    movieList?.let { item ->
                        items(item) {
                            MovieCard(
                                movie = it,
                                onMovieClick = {
                                    navController.navigate("${MOVIE_DETAILS}/${it.id}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}