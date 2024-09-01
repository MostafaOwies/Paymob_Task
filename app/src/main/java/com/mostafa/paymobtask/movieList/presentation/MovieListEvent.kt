package com.mostafa.paymobtask.movieList.presentation

sealed class MovieListEvent {
    data object LoadMovieList : MovieListEvent()
}