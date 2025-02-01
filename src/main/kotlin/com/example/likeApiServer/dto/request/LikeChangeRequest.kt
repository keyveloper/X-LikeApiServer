package com.example.likeApiServer.dto.request

import com.example.likeApiServer.enum.LikeType
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