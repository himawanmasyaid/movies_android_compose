package com.himawanmasyaid.moviescompose.ui.view.movie

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@Composable
fun MovieDetailView(
    navController: NavController,
    movieId: String,
) {

    Text(text = "Detail")

}

@Composable
fun MovieDetail() {


}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun PreviewMovieDetailView() {
    MovieDetail()
}