package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.enum.MSAServerErrorCode

class AuthorizationException(
    errorDetails: MSAServerErrorDetails
): BusinessException(
    errorCode = MSAServerErrorCode.AUTHENTICATION_ERROR,
    errorDetails = errorDetails
)