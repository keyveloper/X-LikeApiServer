package org.example.liveApiServer.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.example.liveApiServer.entity.QLike
import org.example.liveApiServer.entity.QUser
import org.example.liveApiServer.entity.User

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


