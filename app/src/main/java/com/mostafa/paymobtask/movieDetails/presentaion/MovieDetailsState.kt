package com.mostafa.paymobtask.movieDetails.presentaion

import com.mostafa.paymobtask.core.domain.Event
import com.mostafa.paymobtask.movieDetails.domain.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val failure: Event<Throwable>? = null,
    val movieDetails: MovieDetails? = null,
)