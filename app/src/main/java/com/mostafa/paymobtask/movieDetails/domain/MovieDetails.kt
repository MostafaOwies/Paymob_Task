package com.mostafa.paymobtask.movieDetails.domain

data class MovieDetails(
    val adult: Boolean,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val poster: String,
    val releaseDate: String,
    val rating: Double,
    val voteCount: Int,
)