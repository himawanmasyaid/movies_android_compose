package com.himawanmasyaid.moviescompose.ui.view.movie

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.data.response.MovieDetailModel
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadPoster
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadUrl
import com.himawanmasyaid.moviescompose.ui.theme.*


@Composable
fun MovieDetailView(
    navController: NavController,
    viewModel: MovieDetailViewModel,
    movieId: String,
) {

    val movie by viewModel.movie

    viewModel.fetchDetailMovie(movieId.toInt())

    MovieDetail(movie = movie)

}

@Composable
fun MovieDetail(movie: MovieDetailModel) {

    Scaffold {

        LazyColumn(modifier = Modifier.fillMaxWidth()) {

            item {

                Box(
                    modifier = Modifier.background(
                        bgLineColor
                    )
                ) {

                    ImageLoadPoster(
                        imageUrl = movie.backdropPath,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                    )

                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Release ${movie.releaseDate}",
                        fontSize = 12.sp,
                        style = TextStyleTypography.body2,
                        color = textBlack3Color,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = movie.originalTitle,
                        style = TextStyleTypography.h2,
                        modifier = Modifier
                            .fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${movie.voteAverage} Rating",
                        color = textWhiteColor,
                        style = TextStyleTypography.h4,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .background(orangeColor, RoundedCornerShape(30.dp))
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)

                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Summary",
                        style = TextStyleTypography.h3,
                        modifier = Modifier
                            .fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${movie.overview}",
                        fontSize = 12.sp,
                        style = TextStyleTypography.body2,
                        color = textBlack3Color,
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                }
            }

        }

    }



}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun PreviewMovieDetailView() {
    MovieDetail(
        MovieDetailModel(
            originalTitle = "Spider-Man: No Way Home",
            voteAverage = 7.7,
            voteCount = 1743,
            releaseDate = "2021-12-15",
            overview = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
            )

    )
}