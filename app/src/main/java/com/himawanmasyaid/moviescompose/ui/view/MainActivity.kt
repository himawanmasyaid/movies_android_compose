package com.himawanmasyaid.moviescompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.himawanmasyaid.moviescompose.navigation.NavigationView
import com.himawanmasyaid.moviescompose.ui.theme.MoviesAndroidComposeTheme
import com.himawanmasyaid.moviescompose.ui.view.home.HomeViewModel
import com.himawanmasyaid.moviescompose.ui.view.movie.MovieDetailViewModel
import com.himawanmasyaid.moviescompose.ui.view.people.PeopleDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private val movieDetailViewModel by viewModels<MovieDetailViewModel>()
    private val peopleDetailViewModel by viewModels<PeopleDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MoviesAndroidComposeTheme {
                NavigationView(
                    homeViewModel,
                    movieDetailViewModel,
                    peopleDetailViewModel
                )
            }
        }

    }

}






