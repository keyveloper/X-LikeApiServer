package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.enum.MSAServerErrorCode

open class BusinessException(
    val errorCode: MSAServerErrorCode,
    val errorDetails: MSAServerErrorDetails?,
): RuntimeException() {}
