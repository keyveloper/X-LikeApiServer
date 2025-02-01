package com.example.likeApiServer.execption

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.enum.MSAServerErrorCode

class UndefinedLikeType(
    errorDetails: MSAServerErrorDetails
): BusinessException(
    errorCode = MSAServerErrorCode.UNDEFINED_TYPE,
    errorDetails = errorDetails
)