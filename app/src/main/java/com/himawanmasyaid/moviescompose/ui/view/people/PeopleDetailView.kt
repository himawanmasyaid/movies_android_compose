package com.himawanmasyaid.moviescompose.ui.view.people

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himawanmasyaid.moviescompose.data.response.PeopleDetailModel
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadPoster
import com.himawanmasyaid.moviescompose.ui.theme.TextStyleTypography
import com.himawanmasyaid.moviescompose.ui.theme.textBlack3Color
import com.himawanmasyaid.moviescompose.ui.view.home.card.PeopleCard

@Composable
fun PeopleDetailView(
    viewModel: PeopleDetailViewModel,
    peopleId: Int
) {

    val people by viewModel.people_detail

    viewModel.fetchPeopleDetail(peopleId)

    PeopleDetail(people)

}

@Composable
private fun PeopleDetail(people: PeopleDetailModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        // PROFILE
        item {

            ImageLoadPoster(
                imageUrl = people.profilePath,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

        }

        // DETAIL
        item {

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Text(
                    text = people.name,
                    style = TextStyleTypography.h1,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = people.knownForDepartment,
                    style = TextStyleTypography.subtitle2,
                    color = textBlack3Color,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Personal Info",
                    style = TextStyleTypography.subtitle1,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "Birth ${people.placeOfBirth}, ${people.birthday}",
                    style = TextStyleTypography.body2,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                val gender = when(people.gender) {
                    1 -> "Female"
                    2 -> "Male"
                    else -> "Other"
                }

                Text(
                    text = gender,
                    style = TextStyleTypography.body2,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Biography",
                    style = TextStyleTypography.subtitle1,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = people.biography,
                    style = TextStyleTypography.body2,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

            }

        }

    }

}


@Preview(
    showSystemUi = true,
    showBackground = true
)

@Composable
private fun PreviewPeopleDetailView() {
    PeopleDetail(
        PeopleDetailModel(
            name = "Tom Holland",
            gender = 2,
            placeOfBirth = "Surrey, England, UK",
            birthday = "1996-06-01",
            knownForDepartment = "Actor",
            biography = "Thomas \\\"Tom\\\" Stanley Holland is an English actor and dancer. He is best known for playing Peter Parker / Spider-Man in the Marvel Cinematic Universe and has appeared as the character in six films: Captain America: Civil War (2016), Spider-Man: Homecoming (2017), Avengers: Infinity War (2018), Avengers: Endgame (2019), Spider-Man: Far From Home (2019), and Spider-Man: No Way Home (2021). He is also known for playing the title role in Billy Elliot the Musical at the Victoria Palace Theatre, London, as well as for starring in the 2012 film The Impossible."
        )
    )
}