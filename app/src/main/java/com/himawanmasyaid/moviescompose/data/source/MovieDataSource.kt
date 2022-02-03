package com.himawanmasyaid.moviescompose.data.source

import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel

interface MovieDataSource {

    suspend fun fetchMovies(request: MoviesRequest): MovieModel

}