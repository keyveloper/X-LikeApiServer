package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.Like
import org.springframework.data.jpa.repository.JpaRepository


interface LikeRepository: JpaRepository<Like, Long>, LikeQueryDslRepository {
}