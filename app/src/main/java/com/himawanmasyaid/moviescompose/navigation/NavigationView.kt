package com.himawanmasyaid.moviescompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.himawanmasyaid.moviescompose.ui.view.SplashView
import com.himawanmasyaid.moviescompose.ui.view.home.HomeView
import com.himawanmasyaid.moviescompose.ui.view.home.HomeViewModel
import com.himawanmasyaid.moviescompose.ui.view.movie.MovieDetailView

@Composable
fun NavigationView(
    homeViewModel: HomeViewModel
) {

    val navController = rememberNavController()

    setLog("NavigationView")

    NavHost(
        navController = navController,
        startDestination = NavigationDirection.Splash.route
    ) {

        // SPLASH

        composable(
            route = NavigationDirection.Splash.route
        ) {
            SplashView(navController = navController)
        }

        // HOME
        composable(
            route = NavigationDirection.Home.route,
            arguments = emptyList()
        ) {
            HomeView(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }

        // MOVIE
        composable(
            route = NavigationDirection.MovieDetails.routeWithArgument,
            arguments = listOf(
                navArgument(
                    NavigationDirection.MovieDetails.argsId
                ) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(
                NavigationDirection.MovieDetails.argsId
            )?.let {
                MovieDetailView(
                    navController = navController,
                    movieId = it
                )
            }
        }

        // END MOVIE

    }

}

private fun setLog(msg: String) {
    Log.e("Home", msg)
}
