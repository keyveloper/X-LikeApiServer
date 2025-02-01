package com.example.likeApiServer.dto.save.response

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.dto.error.MSAServerErrorResponse
import com.example.likeApiServer.dto.response.LikeServerChangeResult
import com.example.likeApiServer.enum.MSAServerErrorCode

data class LikeServerChangeResponse(
    val result: LikeServerChangeResult,
    override val errorCode: Int,
    override val errorDetails: MSAServerErrorDetails?
): MSAServerErrorResponse(errorCode, errorDetails) {
    companion object {
        fun of(
            result: LikeServerChangeResult,
            errorCode: MSAServerErrorCode,
            errorDetails: MSAServerErrorDetails?,
        ): LikeServerChangeResponse {
            return LikeServerChangeResponse(
                result,
                errorCode.code,
                errorDetails
            )
        }
    }
}