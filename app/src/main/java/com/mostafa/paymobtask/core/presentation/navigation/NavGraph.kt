package com.mostafa.paymobtask.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mostafa.paymobtask.movieDetails.presentaion.MovieDetailsScreen
import com.mostafa.paymobtask.movieList.presentation.MovieListScreen


@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        route = RootGraph.HOME_GRAPH,
        startDestination = HomeRoutes.MovieListScreen.route
    ) {
        composable(route = HomeRoutes.MovieListScreen.route) {
            MovieListScreen(
                navController = navController
            )
        }

        composable(
            route = HomeRoutes.MovieDetailsScreen.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) { backEntry ->
            MovieDetailsScreen(
                movieId = backEntry.arguments?.getString("id")
            )
        }
    }
}