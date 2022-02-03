package com.himawanmasyaid.moviescompose.ui.view.home.card

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.ui.theme.TextStyleTypography
import com.himawanmasyaid.moviescompose.ui.theme.textBlackColor


@Composable
fun MovieCard(movie: MovieModel.Result) {

    androidx.compose.foundation.layout.Box(
        modifier = androidx.compose.ui.Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .width(150.dp)
                .padding(start = 18.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
        ) {
            Text(
//                    text = space.name,
                text = movie.originalTitle,
                style = TextStyleTypography.h3,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

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

//        Text(
//            text = "Sleman, Yogyakarta",
//            color = textBlack3Color,
//            style = Typography.body2, fontSize = 14.sp,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            modifier = Modifier.height(50.dp)
//        )

        }

    }

}

@Composable
private fun MovieCardView() {
    MovieCard(
        MovieModel.Result(
            originalTitle = "Spider-Man: No Way Home",
            overview = "Deskripsi film ini bagus banget",
            voteAverage = 7.7,
            voteCount = 1743,
            releaseDate = "2021-12-15"
        )
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun PreviewMovieCard() {
    MovieCardView()
}
