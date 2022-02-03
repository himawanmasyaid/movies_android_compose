package com.himawanmasyaid.moviescompose.ui.view.home.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.himawanmasyaid.moviescompose.ui.theme.TextStyleTypography
import com.himawanmasyaid.moviescompose.ui.theme.bgLineColor
import com.himawanmasyaid.moviescompose.ui.theme.bgPrimaryColor

@Composable
fun PeopleCard() {

    Column(
        modifier = Modifier
            .height(150.dp)
            .width(120.dp)
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxSize()
            .border(
                BorderStroke(
                    1.dp,
                    SolidColor(bgLineColor)
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color = bgPrimaryColor),
    ) {
        Column {
//            Image(
//                painter = painterResource(id = R.drawable.),
//                contentDescription = "",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .height(120.dp)
//                    .fillMaxSize()
//            )

            Box(modifier = Modifier
                .fillMaxSize()
                .height(120.dp)
                .background(bgLineColor)
            )

            Text(
                text = "province",
                style = TextStyleTypography.body2, fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
            )
        }


    }
    
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun PreviewPeopleCard() {
    PeopleCard()
}