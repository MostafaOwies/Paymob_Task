package com.mostafa.paymobtask.movieDetails.presentaion


sealed class MovieDetailsEvent {
    data class LoadMovieDetails(val movieId: String?) : MovieDetailsEvent()
}