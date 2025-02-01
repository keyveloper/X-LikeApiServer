package com.example.likeApiServer.execption

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.enum.MSAServerErrorCode

open class BusinessException(
    val errorCode: MSAServerErrorCode,
    val errorDetails: MSAServerErrorDetails?,
): RuntimeException() {}
