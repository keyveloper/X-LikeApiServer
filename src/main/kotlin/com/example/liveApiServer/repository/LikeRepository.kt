package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository: JpaRepository<Like, Long>, LikeQueryDslRepository {
    fun findAllByBoardId(boardId: Long): List<Like>
}