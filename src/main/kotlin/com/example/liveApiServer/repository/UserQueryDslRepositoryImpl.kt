package com.example.liveApiServer.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.example.liveApiServer.entity.User
import com.example.liveApiServer.entity.QLike
import com.example.liveApiServer.entity.QUser

class UserQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): UserQueryDslRepository {
    private val qUser = QUser.user
    private val qLike = QLike.like
    override fun findUserIdsLikeThisBoard(boardId: Long): List<User> {
        return queryFactory
            .selectFrom(qUser)
            .join(qLike).on(qUser.id.eq(qLike.userId))
            .where(qLike.boardId.eq(boardId))
            .fetch()
    }
}


