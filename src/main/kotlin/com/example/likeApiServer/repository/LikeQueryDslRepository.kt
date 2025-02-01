package com.example.likeApiServer.repository

import com.example.likeApiServer.entity.Like
import com.example.likeApiServer.enum.LikeType


interface LikeQueryDslRepository {
    fun findByUserIDAndBoardId(userId: Long, boardId: Long): Like?

    fun countLikes(targetBoardId: Long): Long
}