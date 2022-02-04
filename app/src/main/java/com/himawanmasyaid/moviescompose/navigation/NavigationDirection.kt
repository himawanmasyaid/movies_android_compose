package com.himawanmasyaid.moviescompose.navigation

sealed class NavigationDirection(val route: String) {

    object Splash : NavigationDirection("splash")

    object Home : NavigationDirection("home")

    object MovieDetails : NavigationDirection("movies") {
        const val routeWithArgument: String = "movies/{id}"
        const val argsId: String = "id"
    }

}