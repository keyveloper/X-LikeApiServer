package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.User

interface UserQueryDslRepository {
    fun findUserIdsLikeThisBoard(boardId: Long): List<User>
}