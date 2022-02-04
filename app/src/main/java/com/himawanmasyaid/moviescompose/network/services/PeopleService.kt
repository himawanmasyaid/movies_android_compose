package com.himawanmasyaid.moviescompose.network.services

import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleService {

    @GET("/3/person/popular?language=en")
    suspend fun fetchPopularPeople(
        @Query("page") page: Int
    ): PeopleModel

}