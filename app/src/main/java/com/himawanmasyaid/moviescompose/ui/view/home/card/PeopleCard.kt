package com.himawanmasyaid.moviescompose.ui.view.home.card

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.navigation.NavigationDirection
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadPoster
import com.himawanmasyaid.moviescompose.ui.theme.TextStyleTypography
import com.himawanmasyaid.moviescompose.ui.theme.bgLineColor
import com.himawanmasyaid.moviescompose.ui.theme.bgPrimaryColor

@Composable
fun PeopleCard(
    people: PeopleModel.Result,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .padding(
                start = 8.dp, end = 8.dp,
                top = 16.dp, bottom = 16.dp)
            .clickable(onClick = {
                navController.navigate("${NavigationDirection.PeopleDetail.route}/${people.id}")
            })

    ) {

        ImageLoadPoster(
            imageUrl = people.profilePath,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = people.name,
            style = TextStyleTypography.subtitle2,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp)
        )

    }

}

//@Preview(
//    showSystemUi = true,
////    showBackground = true
//)
//@Composable
//private fun PreviewPeopleCard() {
//    PeopleCard(
//        PeopleModel.Result(
//            name = "Manusia"
//        )
//    )
//}