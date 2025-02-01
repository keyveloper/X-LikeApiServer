package com.example.likeApiServer.dto.error

open class MSAServerErrorResponse(
    open val errorCode: Int,
    open val errorDetails: MSAServerErrorDetails?
)