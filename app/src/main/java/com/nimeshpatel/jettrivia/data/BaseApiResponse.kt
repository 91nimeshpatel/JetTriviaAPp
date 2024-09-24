package com.nimeshpatel.jettrivia.data

/**
 * Created by Nimesh Patel on 23-Sep-24.
 * Purpose:
 */
data class BaseApiResponse<T, Boolean, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)