package com.himawanmasyaid.moviescompose.ui.view.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.ui.view.home.card.MovieCard

@Composable
fun HomeView(
    navController: NavController,
    homeViewModel: HomeViewModel
) {

    // rest api
    homeViewModel.fetchHome()

    val movies by homeViewModel.words

    MoviesList(movieList = movies.results)


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
fun MoviesList(movieList: List<MovieModel.Result>) {

    setLog("MoviesList size : ${movieList.size}")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {

        items(movieList) {
            MovieCard(movie = it)
            setLog("data : ${it.title}")
//            Text(text = it.title, style = TextStyleTypography.h2)
        }

    }

//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(4.dp),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//
//        items(movieList) {
//
//            MovieCard(movie = it)
//
//            setLog("data : ${it.title}")
////            Text(text = it.title, style = TextStyleTypography.h2)
//        }
//
//    }

}

private fun setLog(msg: String) {
    Log.e("Home", msg)
}

//@Composable
//fun Home() {
//    Text(text = "Go to detail")
//}
//
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun PreviewHomeView() {
//    Home()
//}




