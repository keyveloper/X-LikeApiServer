package com.example.liveApiServer.service

import com.example.liveApiServer.entity.Like
import com.example.liveApiServer.enum.LikeType
import com.example.liveApiServer.repository.LikeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeService(
    private val likeRepository: LikeRepository,
) {
    @Transactional
    fun save(boardId: Long, userId: Long): Boolean{
        likeRepository.save(
            Like(
                boardId = boardId,
                userId = userId,
                likeType = LikeType.LIKE
            )
        )
        return true
    }

}