package com.himawanmasyaid.moviescompose.ui.view.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    val peoples by homeViewModel.peoples

    Scaffold {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // HOME BAR VIEW
            HomeBarView()

            HomeBarView()

            LazyColumn {

                // PEOPLE

                item {

                    PeopleList(peopleList = peoples.results)

                    Spacer(modifier = Modifier.height(16.dp))

                }

                // MOVIE

                items(movies.results) {
                    MovieCard(movie = it)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

            }
        }

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

//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//private fun PreviewHomeView() {
//    HomeView(
//        null,
//        null
//    )
//}


