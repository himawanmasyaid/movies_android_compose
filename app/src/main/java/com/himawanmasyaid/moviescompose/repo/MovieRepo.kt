package com.himawanmasyaid.moviescompose.repo

import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.source.MovieDataSource
import com.himawanmasyaid.moviescompose.network.services.MovieService
import javax.inject.Inject

class MovieRepo @Inject constructor(
    val services: MovieService
): MovieDataSource {

    override suspend fun fetchMovies(request: MoviesRequest): MovieModel {
        val response = services.fetchPopularMovie(request.page)
        return response
    }

}