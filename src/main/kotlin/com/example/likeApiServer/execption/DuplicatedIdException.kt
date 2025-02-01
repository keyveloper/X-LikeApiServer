package com.example.likeApiServer.execption

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.enum.MSAServerErrorCode

class DuplicatedIdException(
    errorDetails: MSAServerErrorDetails
): BusinessException(
    errorCode = MSAServerErrorCode.DUPLICATED_ID,
    errorDetails = errorDetails
)