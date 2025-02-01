package com.example.likeApiServer.repository

import com.example.likeApiServer.entity.Like
import com.example.likeApiServer.entity.QLike
import com.querydsl.jpa.impl.JPAQueryFactory

class LikeQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
):LikeQueryDslRepository {
    private val like = QLike.like

    override fun findByUserIDAndBoardId(userId: Long, boardId: Long): Like? {
        return queryFactory
            .selectFrom(like)
            .where(like.boardId.eq(boardId)
                .and(like.userId.eq(userId)))
            .fetchOne()
    }

    override fun countLikes(targetBoardId: Long): Long {
        return queryFactory
            .select(like.count())
            .from(like)
            .where(like.boardId.eq(targetBoardId))
            .fetchOne() ?: 0L
    }
}