package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long>, BoardQueryDslRepository{
}