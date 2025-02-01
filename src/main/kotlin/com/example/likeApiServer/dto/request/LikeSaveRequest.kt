package com.example.likeApiServer.dto.request

import com.example.likeApiServer.enum.LikeType
import org.jetbrains.annotations.NotNull

data class LikeSaveRequest(
    @field: NotNull
    val boardId: Long,
    @field: NotNull
    val userId: Long,
    @field: NotNull
    val likeType: LikeType,
)