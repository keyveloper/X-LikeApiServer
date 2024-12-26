package com.example.liveApiServer.dto.error

import com.example.liveApiServer.enum.MSAServerErrorCode

open class MSAServerErrorResponse(
    open val errorCode: MSAServerErrorCode,
    open val errorDetails: MSAServerErrorDetails?
)