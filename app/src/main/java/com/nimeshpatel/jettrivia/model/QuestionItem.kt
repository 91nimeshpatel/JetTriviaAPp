package com.nimeshpatel.jettrivia.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class QuestionItem(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
) : Parcelable