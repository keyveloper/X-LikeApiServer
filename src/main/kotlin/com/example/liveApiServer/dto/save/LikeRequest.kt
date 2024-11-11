package com.example.liveApiServer.dto.save

import com.example.liveApiServer.enum.LikeType
import org.jetbrains.annotations.NotNull

data class LikeRequest(
    @field: NotNull
    val boardId: Long,
    @field: NotNull
    val userId: Long,
    @field: NotNull
    val likeType: LikeType,
)