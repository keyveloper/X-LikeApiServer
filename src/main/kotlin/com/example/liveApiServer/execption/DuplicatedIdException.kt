package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.enum.MSAServerErrorCode

class DuplicatedIdException(
    errorDetails: MSAServerErrorDetails
): BusinessException(
    errorCode = MSAServerErrorCode.DUPLICATED_ID,
    errorDetails = errorDetails
)