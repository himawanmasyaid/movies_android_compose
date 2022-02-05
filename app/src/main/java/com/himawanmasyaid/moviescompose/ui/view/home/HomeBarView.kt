package com.himawanmasyaid.moviescompose.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himawanmasyaid.moviescompose.R
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadDrawable
import com.himawanmasyaid.moviescompose.ui.theme.*


@Composable
fun HomeBarView() {

    Column() {

        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                text = "Compose",
                color = Color.Black,
                style = TextStyleTypography.h1,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .weight(1f)
            )

            ImageLoadDrawable(
                painter = painterResource(id = R.drawable.ic_jetpack_compose_logo),
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp),
            )

        }


        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(bgLineColor)
        )

    }


}

@Preview(
    showBackground = true
)
@Composable
private fun PreviewHomeBarView() {
    HomeBarView()
}
