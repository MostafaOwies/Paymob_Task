package com.mostafa.paymobtask.core.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMovieList(
    @field:Json(name = "page") val page: Int?,
    @field:Json(name = "results") val results: List<ApiMovieListResult>,
    @field:Json(name = "total_pages") val totalPages: Int?,
    @field:Json(name = "total_results") val totalResults: Int?,
)

@JsonClass(generateAdapter = true)
data class ApiMovieListResult(
    @field:Json(name = "adult") val adult: Boolean?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "original_language") val originalLanguage: String?,
    @field:Json(name = "original_title") val originalTitle: String?,
    @field:Json(name = "overview") val overview: String?,
    @field:Json(name = "poster_path") val poster: String?,
    @field:Json(name = "release_date") val releaseDate: String?,
    @field:Json(name = "vote_average") val rating: Double?,
    @field:Json(name = "vote_count") val voteCount: Int?,
)