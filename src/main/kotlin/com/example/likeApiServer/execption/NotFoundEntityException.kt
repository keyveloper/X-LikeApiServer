package com.example.likeApiServer.execption

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.enum.MSAServerErrorCode

class NotFoundEntityException(
    errorDetails: MSAServerErrorDetails
): BusinessException(MSAServerErrorCode.INVALID_ID, errorDetails)