package com.himawanmasyaid.moviescompose.ui.view.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.moviescompose.data.request.MoviesRequest
import com.himawanmasyaid.moviescompose.data.response.MovieModel
import com.himawanmasyaid.moviescompose.data.state.ViewState
import com.himawanmasyaid.moviescompose.repo.MovieRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepo: MovieRepo
) : ViewModel() {

    // reponse
    val homeState = MutableLiveData<ViewState<MovieModel>>()

    val movies: MutableList<MovieModel.Result> = ArrayList()
    val moviesState: State<MutableList<MovieModel.Result>> = mutableStateOf(mutableListOf())

//    var moviesResponse by mutableStateOf(MovieResponse)

    private val _words = mutableStateOf(MovieModel()) // 1
    val words: State<MovieModel> = _words


//    val homeSampleState = MutableStateFlow(ResponseState<MovieResponse>(
//        state = NetworkState.LOADING,
//        response = MovieResponse = MovieResponse()
//        ))

//    private val _homeState: MutableState<NetworkState> = mutableStateOf(NetworkState.LOADING)
//    val homeState: State<NetworkState> get() = _homeState

//    init {
//        fetchHome()
//    }

    fun fetchHome() {
        viewModelScope.launch {
            homeState.postValue(ViewState.Loading())
            try {

                setLog("start rest api")

                val response = movieRepo.fetchMovies(MoviesRequest(page = 1))
                _words.value = response

                homeState.postValue(ViewState.Success(response))

                setLog("succes")

            } catch (error: Exception) {
                setLog("error : ${error.message}")
                homeState.postValue(ViewState.Error(error.message))
            }
        }
    }

    private fun setLog(msg: String) {
        Log.e("Home", msg)
    }


}