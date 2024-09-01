package com.mostafa.paymobtask.movieList.domain


data class MovieList(
    val page: Int,
    val results: List<MovieListResult>,
    val totalPages: Int,
    val totalResults: Int,
)

data class MovieListResult(
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