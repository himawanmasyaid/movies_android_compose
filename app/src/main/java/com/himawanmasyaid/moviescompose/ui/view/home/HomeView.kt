package com.himawanmasyaid.moviescompose.ui.view.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.ui.view.home.card.MovieCard
import com.himawanmasyaid.moviescompose.ui.view.home.card.PeopleCard

@Composable
fun HomeView(
    navController: NavController,
    homeViewModel: HomeViewModel
) {

    // rest api
    homeViewModel.fetchHome()

    val movies by homeViewModel.words

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // PEOPLE



        // MOVIE

        Spacer(modifier = Modifier.height(16.dp))

        MoviesList(movieList = movies.results)

        Spacer(modifier = Modifier.height(16.dp))

    }

//    Text(
//        text = "Go to detail",
//        modifier = Modifier
//            .clickable(
//                onClick = {
//                    navController.navigate(
//                        "${NavigationDirection.MovieDetails.route}/123"
//                    )
//                }
//            )
//    )

}


@Composable
fun PeopleList(peopleList: List<PeopleModel.Result>) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        items(peopleList) {
            PeopleCard(people = it)
        }

    }

}

@Composable
fun MoviesList(movieList: List<MovieModel.Result>) {

    LazyColumn {

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(movieList) {
            MovieCard(movie = it)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}



