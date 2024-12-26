package com.example.liveApiServer.dto.save.request

import com.example.liveApiServer.enum.LikeType

data class LikeChangeResult(
    val isChanged: Boolean,
    val likeId: Long,
    val changedType: LikeType,
)
