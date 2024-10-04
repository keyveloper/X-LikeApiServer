package org.example.liveApiServer.repository

import org.example.liveApiServer.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long>, BoardQueryDslRepository{
}