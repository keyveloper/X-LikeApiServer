package com.example.liveApiServer.dto.save

import com.example.liveApiServer.dto.ServerErrorDetails
import com.example.liveApiServer.enum.ServiceServerError

data class LikeServerSaveResponse(
    val details: ServerErrorDetails?,
    val error: ServiceServerError?
) {
    companion object {
        fun of(result: LikeServerSaveResult): LikeServerSaveResponse {
            return LikeServerSaveResponse(
                details = result.details,
                error = result.error
            )
        }
    }
}