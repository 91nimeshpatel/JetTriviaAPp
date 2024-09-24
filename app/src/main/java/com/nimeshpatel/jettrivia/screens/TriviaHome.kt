package com.nimeshpatel.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.nimeshpatel.jettrivia.component.Questions

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
@Composable
fun TriviaHome (viewModel: QuestionViewModel = hiltViewModel()) {
    Questions(viewModel)
}