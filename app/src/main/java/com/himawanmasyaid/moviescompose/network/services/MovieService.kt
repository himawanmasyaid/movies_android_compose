package com.himawanmasyaid.moviescompose.network.services

import com.himawanmasyaid.moviescompose.data.response.MovieDetailModel
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    suspend fun fetchPopularMovie(
        @Query("page") page: Int
    ): MovieModel

    @GET("/3/movie/{id}")
    suspend fun fetchDetailMovie(
        @Path("id") id: Int
    ): MovieDetailModel

}