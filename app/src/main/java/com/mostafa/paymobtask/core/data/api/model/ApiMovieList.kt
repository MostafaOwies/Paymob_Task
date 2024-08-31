package com.mostafa.paymobtask.core.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class ApiMovieList(
    @field:Json(name = "page") val page: Int?,
    @field:Json(name = "results") val results: MovieListResult,
    @field:Json(name = "total_pages") val totalPages: Int?,
    @field:Json(name = "total_results") val totalResults: Int?,
)

@JsonClass(generateAdapter = true)

data class MovieListResult(
    @field:Json(name = "adult") val adult: Boolean?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "original_language") val originalLanguage: String?,
    @field:Json(name = "original_title") val originalTitle: String?,
    @field:Json(name = "overview") val overview: String?,
    @field:Json(name = "poster_path") val poster: Int?,
    @field:Json(name = "release_date") val releaseDate: String?,
    )