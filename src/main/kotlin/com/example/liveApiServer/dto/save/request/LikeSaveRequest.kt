package com.example.liveApiServer.dto.save.request

import com.example.liveApiServer.enum.LikeType
import org.jetbrains.annotations.NotNull

data class LikeSaveRequest(
    @field: NotNull
    val boardId: Long,
    @field: NotNull
    val userId: Long,
    @field: NotNull
    val likeType: LikeType,
)