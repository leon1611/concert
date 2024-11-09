package com.example.concert.response

    data class SuccessResponse(
        val status: String = "success",
        val data: Any? = null
    )