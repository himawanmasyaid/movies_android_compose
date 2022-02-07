package com.himawanmasyaid.moviescompose.ui.view.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.request.PeopleRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import com.himawanmasyaid.moviescompose.data.state.ResponseState
import com.himawanmasyaid.moviescompose.repo.MovieRepo
import com.himawanmasyaid.moviescompose.repo.PeopleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepo: MovieRepo,
    private val peopleRepo: PeopleRepo
) : ViewModel() {

    // state
    private val _movieState: MutableState<ResponseState> = mutableStateOf(ResponseState.WAITING)
    val movieState: State<ResponseState> = _movieState

    private val _peopleState: MutableState<ResponseState> = mutableStateOf(ResponseState.WAITING)
    val peopleState: State<ResponseState> = _movieState

    // response
    private val _words = mutableStateOf(MovieModel())
    val words: State<MovieModel> = _words

    private val _peoples = mutableStateOf(PeopleModel())
    val peoples: State<PeopleModel> = _peoples


    fun fetchHome() {
        viewModelScope.launch {
            _movieState.value = ResponseState.LOADING
            try {

                val people_response = peopleRepo.fetchPeople(PeopleRequest(page = 1))
                val movie_response = movieRepo.fetchMovies(MoviesRequest(page = 1))

                _peoples.value = people_response
                _words.value = movie_response

                _movieState.value = ResponseState.SUCCESS

            } catch (error: Exception) {
                _movieState.value = ResponseState.ERROR
            }
        }
    }

}