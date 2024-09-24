package com.nimeshpatel.jettrivia.network

import com.nimeshpatel.jettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}