package com.example.likeApiServer.dto.response

data class LikeServerCountResult(
    val targetBoardId: Long,
    val totalCount: Long,
) {
    companion object {
        fun of(targetBoardId: Long, totalCount: Long): LikeServerCountResult {
            return LikeServerCountResult(
                targetBoardId = targetBoardId,
                totalCount = totalCount
            )
        }
    }
}