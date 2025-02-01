package com.example.likeApiServer.dto.request

import jakarta.validation.constraints.NotNull

data class LikeCountGetRequest(
    @field: NotNull
    val targetBoardId: Long
)
