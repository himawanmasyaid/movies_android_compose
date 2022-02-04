package com.himawanmasyaid.moviescompose.data.source

import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.request.PeopleRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.response.PeopleModel

interface PeopleDataSource {

    suspend fun fetchPeople(request: PeopleRequest): PeopleModel

}