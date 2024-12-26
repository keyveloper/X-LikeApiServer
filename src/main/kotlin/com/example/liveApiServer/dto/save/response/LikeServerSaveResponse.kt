package com.example.liveApiServer.dto.save.response

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.dto.error.MSAServerErrorResponse
import com.example.liveApiServer.enum.MSAServerErrorCode

data class LikeServerSaveResponse(
    override val errorCode: MSAServerErrorCode,
    override val errorDetails: MSAServerErrorDetails?,
): MSAServerErrorResponse(errorCode, errorDetails) {
    companion object {
        fun of(
            errorCode: MSAServerErrorCode,
            errorDetails: MSAServerErrorDetails?,
        ): LikeServerSaveResponse {
            return LikeServerSaveResponse(
                errorCode,
                errorDetails
            )
        }
    }
}