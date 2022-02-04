package com.himawanmasyaid.moviescompose.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.compose.runtime.remember
import com.himawanmasyaid.moviescompose.navigation.NavigationView
import com.himawanmasyaid.moviescompose.ui.theme.MoviesAndroidComposeTheme
import com.himawanmasyaid.moviescompose.ui.view.home.HomeViewModel
import com.himawanmasyaid.moviescompose.ui.view.movie.MovieDetailViewModel
import com.himawanmasyaid.moviescompose.ui.view.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private val splashViewModel by viewModels<SplashViewModel>()
    private val movieDetailViewModel by viewModels<MovieDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MoviesAndroidComposeTheme {
                NavigationView(
                    homeViewModel,
                    movieDetailViewModel
                )
            }
        }

    }

}


//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}






