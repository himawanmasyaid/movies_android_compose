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
import com.himawanmasyaid.moviescompose.ui.view.movie.MovieDetailViewModel
import com.himawanmasyaid.moviescompose.ui.view.people.PeopleDetailView
import com.himawanmasyaid.moviescompose.ui.view.people.PeopleDetailViewModel

@Composable
fun NavigationView(
    homeViewModel: HomeViewModel,
    movieDetailViewModel: MovieDetailViewModel,
    peopleDetailViewModel: PeopleDetailViewModel
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
                    viewModel = movieDetailViewModel,
                    movieId = it
                )
            }
        }

        // END MOVIE

        // PEOPLE

        composable(
            route = NavigationDirection.PeopleDetail.routeWithArgument,
            arguments = listOf(
                navArgument(
                    NavigationDirection.PeopleDetail.argsId
                ) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(
                NavigationDirection.PeopleDetail.argsId
            )?.let {
                PeopleDetailView(
                    viewModel = peopleDetailViewModel,
                    peopleId = it.toInt()
                )
            }
        }

        // END PEOPLE

    }

}

private fun setLog(msg: String) {
    Log.e("Home", msg)
}
