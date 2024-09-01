package com.mostafa.paymobtask.core.presentation.navigation

import androidx.annotation.StringRes
import com.mostafa.paymobtask.R

object RootGraph {
    const val HOME_GRAPH = "home_graph"
    const val MOVIE_DETAILS = "movie_details"
}

enum class HomeRoutes(val route: String, @StringRes val title: Int, val icon: Int? = null) {
    MovieListScreen(
        route = MOVIE, title = R.string.movieList
    ),
    MovieDetailsScreen(
        route = RootGraph.MOVIE_DETAILS, title = R.string.movieDetails
    )
}

const val MOVIE = "movie"