package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface LikeRepository: JpaRepository<Like, Long>, LikeQueryDslRepository {
    fun findByBoardId(boardId: Long): List<Like>
}