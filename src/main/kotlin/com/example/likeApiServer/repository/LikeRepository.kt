package com.example.likeApiServer.repository

import com.example.likeApiServer.entity.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository: JpaRepository<Like, Long>, LikeQueryDslRepository {
    fun findAllByBoardId(boardId: Long): List<Like>
}