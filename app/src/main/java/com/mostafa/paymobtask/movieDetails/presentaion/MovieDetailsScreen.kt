package com.mostafa.paymobtask.movieDetails.presentaion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.mostafa.paymobtask.core.utils.ComposableLifecycle
import com.mostafa.paymobtask.core.utils.Logger

@Composable
fun MovieDetailsScreen() {

    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    ComposableLifecycle { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            viewModel.onEvent(MovieDetailsEvent.LoadMovieDetails("278"))
        }
    }

    val state = viewModel.movieDetailsState.collectAsState().value

    Logger.i("MOVIE DETAILS ${state.movieDetails}")
}