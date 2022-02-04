package com.himawanmasyaid.moviescompose.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.himawanmasyaid.moviescompose.data.state.ResponseState
import com.himawanmasyaid.moviescompose.data.state.onLoading

@Composable
fun LoadingView(state: ResponseState) {

    state.onLoading {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                progress = 5.0f
            )
        }
    }


}