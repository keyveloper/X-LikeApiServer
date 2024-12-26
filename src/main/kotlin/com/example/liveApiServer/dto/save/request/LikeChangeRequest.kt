package com.example.liveApiServer.dto.save.request

import com.example.liveApiServer.enum.LikeType
import jakarta.validation.constraints.NotNull

data class LikeChangeRequest(
    @field:NotNull
    val userId: Long,
    @field:NotNull
    val boardId: Long,
    @field:NotNull
    val type: LikeType
) {

}