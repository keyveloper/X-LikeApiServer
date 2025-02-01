package com.example.likeApiServer.repository

import com.example.likeApiServer.entity.Like
import com.example.likeApiServer.enum.LikeType


interface LikeQueryDslRepository {
    fun findByUserIDAndBoardId(userId: Long, boardId: Long): Like?

    fun changType(likeId: Long, type: LikeType)
    // 발생가능한 오류: id 찾을 수 없음.
}