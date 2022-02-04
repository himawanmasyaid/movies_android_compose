package com.himawanmasyaid.moviescompose.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himawanmasyaid.moviescompose.ui.theme.TextStyleTypography
import com.himawanmasyaid.moviescompose.ui.theme.primaryColor
import com.himawanmasyaid.moviescompose.ui.theme.secondaryColor
import com.himawanmasyaid.moviescompose.ui.theme.textBlackColor


@Composable
fun HomeBarView() {
    
    Text(
        text = "MOVIES COMPOSE",
        color = primaryColor,
        style = TextStyleTypography.h1,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    )
    
}

@Preview(
    showBackground = true
)
@Composable
private fun PreviewHomeBarView() {
    HomeBarView()
}
