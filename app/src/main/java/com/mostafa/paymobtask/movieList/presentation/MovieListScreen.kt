package com.mostafa.paymobtask.movieList.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.mostafa.paymobtask.core.utils.ComposableLifecycle
import com.mostafa.paymobtask.core.utils.Logger


@Composable
fun MovieListScreen() {
    val viewModel = hiltViewModel<MovieListViewModel>()
    ComposableLifecycle { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            viewModel.onEvent(MovieListEvent.LoadMovieList)
        }
    }

    val state = viewModel.movieListState.collectAsState().value

    Logger.i("MOVIE LIST ${state.movieList}")


}