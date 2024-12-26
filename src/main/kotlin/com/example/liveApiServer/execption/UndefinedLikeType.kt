package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.enum.MSAServerErrorCode

class UndefinedLikeType(
    errorDetails: MSAServerErrorDetails
): BusinessException(
    errorCode = MSAServerErrorCode.UNDEFINED_TYPE,
    errorDetails = errorDetails
)