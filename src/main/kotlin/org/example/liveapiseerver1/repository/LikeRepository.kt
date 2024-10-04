package org.example.liveApiServer.repository

import org.example.liveApiServer.entity.Like
import org.springframework.data.jpa.repository.JpaRepository


interface LikeRepository: JpaRepository<Like, Long>, LikeQueryDslRepository {
}