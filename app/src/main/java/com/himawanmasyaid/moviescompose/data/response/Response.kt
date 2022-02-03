package com.himawanmasyaid.moviescompose.data.response

import retrofit2.Response


class Response<T>(val response: Response<T>) {
//    val statusCode: StatusCode = getStatusCodeFromResponse(response)
//    val headers: Headers = response.headers()
//    val raw: okhttp3.Response = response.raw()
//    val data: T by lazy { response.body() ?: throw NoContentException(statusCode.code) }
//    override fun toString(): String = "[ApiResponse.Success](data=$data)"
}