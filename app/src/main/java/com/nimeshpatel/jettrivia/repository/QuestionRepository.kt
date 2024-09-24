package com.nimeshpatel.jettrivia.repository

import com.nimeshpatel.jettrivia.data.BaseApiResponse
import com.nimeshpatel.jettrivia.model.QuestionItem
import com.nimeshpatel.jettrivia.network.QuestionApi
import javax.inject.Inject

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
class QuestionRepository @Inject constructor(private val questionApi: QuestionApi) {
    private val baseApiResponse = BaseApiResponse<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestion(): BaseApiResponse<ArrayList<QuestionItem>, Boolean, Exception> {
        try {

            baseApiResponse.loading = true
            baseApiResponse.data = questionApi.getAllQuestions()
            if (baseApiResponse.data.toString().isNotEmpty()) baseApiResponse.loading = false
        } catch (e: Exception) {
            baseApiResponse.e = e
            baseApiResponse.loading = false

        }
        return baseApiResponse
    }


}