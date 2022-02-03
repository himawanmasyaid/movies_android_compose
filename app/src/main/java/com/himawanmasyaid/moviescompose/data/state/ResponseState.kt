package com.himawanmasyaid.moviescompose.data.state

data class ResponseState<T>(
    val state: NetworkState,
    val response : T
) {

//    data class Success<T>(var data: T) : ViewState<T>()
//
//    data class Loading<T>(var progress: Float? = null) : ResponseState<T>()
//    data class Success<T>(var data: T) : ViewState<T>()
//    data class Error<T>(var viewError: String? = null) : ResponseState<T>()

}