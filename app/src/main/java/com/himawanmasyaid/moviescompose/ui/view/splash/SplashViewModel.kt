package com.himawanmasyaid.moviescompose.ui.view.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.moviescompose.data.response.PeopleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

): ViewModel() {


    private val _splash = mutableStateOf(Int) // 1
//    val splash: State<Int> = _splash

    fun start() {

        viewModelScope.launch {

            GlobalScope.launch {
                delay(2000)

//                splash.value =
            }

        }

    }

}