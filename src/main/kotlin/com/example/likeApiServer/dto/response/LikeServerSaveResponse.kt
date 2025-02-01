package com.example.likeApiServer.dto.save.response

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.dto.error.MSAServerErrorResponse
import com.example.likeApiServer.dto.response.LikeServerSaveResult

data class LikeServerSaveResponse(
    val result: LikeServerSaveResult,
    override val errorCode: Int,
    override val errorDetails: MSAServerErrorDetails?,
): MSAServerErrorResponse(errorCode, errorDetails) {
    companion object {
        fun of(
            result: LikeServerSaveResult,
            errorCode: Int,
            errorDetails: MSAServerErrorDetails?,
        ): LikeServerSaveResponse {
            return LikeServerSaveResponse(
                result = result,
                errorCode,
                errorDetails
            )
        }
    }
}