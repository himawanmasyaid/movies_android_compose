package com.himawanmasyaid.moviescompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.himawanmasyaid.moviescompose.R
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.navigation.NavigationDirection
import com.himawanmasyaid.moviescompose.ui.common.ImageLoadDrawable
import com.himawanmasyaid.moviescompose.ui.view.home.card.PeopleCard
import kotlinx.coroutines.delay

@Composable
fun SplashView(
    navController: NavController,
    ) {

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LogoView()

        LaunchedEffect(key1 = true) {
            delay(2000L)

            navController.navigate(NavigationDirection.Home.route)

        }
        
    }

}

@Composable
private fun LogoView() {
    ImageLoadDrawable(
        painter = painterResource(id = R.drawable.ic_jetpack_compose_logo),
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun PreviewPSplashView() {
    LogoView()
}