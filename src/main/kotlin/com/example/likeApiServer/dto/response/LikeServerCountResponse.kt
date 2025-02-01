package com.example.likeApiServer.dto.response

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.dto.error.MSAServerErrorResponse

data class LikeServerCountResponse(
    val result: LikeServerCountResult,
    override val errorCode: Int,
    override val errorDetails: MSAServerErrorDetails?
): MSAServerErrorResponse(errorCode, errorDetails) {
    companion object {
        fun of(
            result: LikeServerCountResult,
            errorCode: Int,
            errorDetails: MSAServerErrorDetails?,
        ): LikeServerCountResponse {
            return LikeServerCountResponse(
                result = result,
                errorCode = errorCode,
                errorDetails = errorDetails
            )
        }
    }
}