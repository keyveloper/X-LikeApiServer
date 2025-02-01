package com.example.likeApiServer.dto.response

import com.example.likeApiServer.entity.Like

data class LikeServerSaveResult(
    val isSave: Boolean,
    val id: Long?,
    val targetBoardId: Long?,
) {
    companion object {
        fun of(
            isSave: Boolean,
            likeEntity: Like
        ): LikeServerSaveResult {
            return LikeServerSaveResult(
                isSave = isSave,
                id = likeEntity.id!!,
                targetBoardId = likeEntity.boardId
            )
        }
    }
}