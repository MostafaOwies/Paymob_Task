package com.mostafa.paymobtask.movieList.presentation

import com.mostafa.paymobtask.core.domain.Event
import com.mostafa.paymobtask.movieList.domain.MovieList

data class MovieListState(
    val isLoading: Boolean = false,
    val failure: Event<Throwable>? = null,
    val movieList: MovieList? = null,
)