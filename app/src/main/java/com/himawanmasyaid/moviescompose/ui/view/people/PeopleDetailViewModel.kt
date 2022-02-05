package com.himawanmasyaid.moviescompose.ui.view.people

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.moviescompose.data.response.MovieDetailModel
import com.himawanmasyaid.moviescompose.data.response.PeopleDetailModel
import com.himawanmasyaid.moviescompose.repo.PeopleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    val peopleRepo: PeopleRepo
) : ViewModel() {

    // response
    private val _people_detail = mutableStateOf(PeopleDetailModel()) // 1
    val people_detail: State<PeopleDetailModel> = _people_detail

    fun fetchPeopleDetail(id: Int) {

        viewModelScope.launch {
            try {

                val response = peopleRepo.fetchPeopleDetail(id)
                _people_detail.value = response

            } catch (error: Exception) {
                Log.e("Error", error.message ?: "")
            }
        }

    }


}