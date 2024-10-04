package org.example.liveApiServer.repository

interface BoardQueryDslRepository {
    fun updateLikeCountByBoardId(boardId: Long): Boolean
}