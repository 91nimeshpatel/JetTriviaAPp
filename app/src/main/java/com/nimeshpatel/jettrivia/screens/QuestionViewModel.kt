package com.nimeshpatel.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nimeshpatel.jettrivia.data.BaseApiResponse
import com.nimeshpatel.jettrivia.model.QuestionItem
import com.nimeshpatel.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {

        val data: MutableState<BaseApiResponse<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(BaseApiResponse(null, true, Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestion()
            //Set loading to false
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false

        }
    }

    fun getTotalQn(): Int{
        return data.value.data?.toMutableList()?.size?:0
    }
}
