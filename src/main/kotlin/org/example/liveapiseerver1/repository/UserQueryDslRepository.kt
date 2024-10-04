package org.example.liveApiServer.repository

import org.example.liveApiServer.entity.User

interface UserQueryDslRepository {
    fun findUserIdsLikeThisBoard(boardId: Long): List<User>
}