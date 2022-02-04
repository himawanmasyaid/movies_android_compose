package com.himawanmasyaid.moviescompose.repo

import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.request.PeopleRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.data.source.PeopleDataSource
import com.himawanmasyaid.moviescompose.network.services.MovieService
import com.himawanmasyaid.moviescompose.network.services.PeopleService
import javax.inject.Inject

class PeopleRepo @Inject constructor(
    val services: PeopleService
): PeopleDataSource {

    override suspend fun fetchPeople(request: PeopleRequest): PeopleModel {
        val response = services.fetchPopularPeople(request.page)
        return response
    }
}