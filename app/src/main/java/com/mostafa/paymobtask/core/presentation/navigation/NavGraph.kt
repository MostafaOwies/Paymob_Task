package com.mostafa.paymobtask.core.presentation.navigation

import android.provider.DocumentsContract.Root
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
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
        startDestination =MOVIE
    ) {
        composable(route = HomeRoutes.MovieListScreen.route) {
            MovieListScreen()
        }
    }
}