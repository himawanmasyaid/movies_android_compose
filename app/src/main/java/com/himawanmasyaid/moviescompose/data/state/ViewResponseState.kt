package com.himawanmasyaid.moviescompose.data.state

import androidx.compose.runtime.Composable

@Composable
fun ResponseState.onSuccess(block: @Composable () -> Unit): ResponseState {
    if (this == ResponseState.SUCCESS) {
        block()
    }
    return this
}

@Composable
fun ResponseState.onLoading(block: @Composable () -> Unit): ResponseState {
    if (this == ResponseState.LOADING) {
        block()
    }
    return this
}

@Composable
fun ResponseState.onError(block: @Composable () -> Unit): ResponseState {
    if (this == ResponseState.ERROR) {
        block()
    }
    return this
}