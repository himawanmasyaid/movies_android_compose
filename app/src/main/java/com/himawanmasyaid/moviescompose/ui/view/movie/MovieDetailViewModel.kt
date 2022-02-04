package com.himawanmasyaid.moviescompose.ui.view.movie

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.request.PeopleRequest
import com.himawanmasyaid.moviescompose.data.response.MovieDetailModel
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.state.ResponseState
import com.himawanmasyaid.moviescompose.repo.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel  @Inject constructor(
    val movieRepo: MovieRepo
): ViewModel() {

    // response
    private val _movie = mutableStateOf(MovieDetailModel()) // 1
    val movie: State<MovieDetailModel> = _movie

    fun fetchDetailMovie(id: Int) {

        viewModelScope.launch {
            try {

                val response = movieRepo.fetchDetailMovies(id)
                _movie.value = response

            } catch (error: Exception) {
                Log.e("Error", error.message ?: "")
            }
        }

    }


}