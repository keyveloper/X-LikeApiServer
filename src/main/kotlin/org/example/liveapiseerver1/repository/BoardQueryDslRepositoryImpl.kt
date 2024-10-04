package org.example.liveApiServer.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.example.liveApiServer.entity.QBoard

class BoardQueryDslRepositoryImpl(
    @PersistenceContext
    private val entityManger: EntityManager,
    private val queryFactory: JPAQueryFactory
) : BoardQueryDslRepository {
    private val qBoard = QBoard.board
    override fun updateLikeCountByBoardId(boardId: Long): Boolean {
        val updateRows = queryFactory
            .update(qBoard)
            .set(qBoard.likeCount, qBoard.likeCount.add(1))
            .where(qBoard.id.eq(boardId))
            .execute()

        entityManger.clear()
        entityManger.flush()

        return updateRows > 0
    }
}