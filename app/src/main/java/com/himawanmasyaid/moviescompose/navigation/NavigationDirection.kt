package com.himawanmasyaid.moviescompose.navigation

sealed class NavigationDirection(val route: String) {

    object Splash : NavigationDirection("splash")

    object Home : NavigationDirection("home")

    object MovieDetails : NavigationDirection("movie_detail") {
        const val routeWithArgument: String = "movie_detail/{id}"
        const val argsId: String = "id"
    }

    object PeopleDetail : NavigationDirection("people_detail") {
        const val routeWithArgument: String = "people_detail/{id}"
        const val argsId: String = "id"
    }

}