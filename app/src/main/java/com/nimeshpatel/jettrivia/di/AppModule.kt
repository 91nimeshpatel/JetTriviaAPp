package com.nimeshpatel.jettrivia.di

import com.nimeshpatel.jettrivia.network.QuestionApi
import com.nimeshpatel.jettrivia.repository.QuestionRepository
import com.nimeshpatel.jettrivia.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideQuestionRepository(questionApi: QuestionApi) = QuestionRepository(questionApi)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}