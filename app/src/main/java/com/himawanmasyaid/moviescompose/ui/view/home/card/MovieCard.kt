package com.himawanmasyaid.moviescompose.ui.view.home.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.navigation.NavigationDirection
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadPoster
import com.himawanmasyaid.moviescompose.ui.theme.*


@Composable
fun MovieCard(
    movie: MovieModel.Result,
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                BorderStroke(
                    1.5.dp,
                    SolidColor(bgLineColor)
                ),
                RoundedCornerShape(10.dp)
            )
            .clickable(
                onClick = {
                    navController.navigate("${NavigationDirection.MovieDetails.route}/${movie.id}")
                }
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            ImageLoadPoster(
                imageUrl = movie.posterPath,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = movie.originalTitle,
                    style = TextStyleTypography.subtitle1,
                    fontSize = 24.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Release Date : ${movie.releaseDate}",
                    color = textBlackColor,
                    style = TextStyleTypography.subtitle1,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = "${movie.voteAverage} Rating",
                    color = textWhiteColor,
                    style = TextStyleTypography.h5,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .background(orangeColor, RoundedCornerShape(30.dp))
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)

                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${movie.voteCount} People Votes",
                    color = textBlack3Color,
                    style = TextStyleTypography.body2,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }

        }
    }

}

//@Composable
//private fun MovieCardView() {
//    MovieCard(
//        MovieModel.Result(
//            originalTitle = "Spider-Man: No Way Home",
//            overview = "Deskripsi film ini bagus banget",
//            voteAverage = 7.7,
//            voteCount = 1743,
//            releaseDate = "2021-12-15"
//        )
//    )
//}

//@Preview(
//    showBackground = true
//)
//@Composable
//private fun PreviewMovieCard() {
//    MovieCardView()
//}
