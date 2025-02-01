package com.example.likeApiServer.dto.response

data class LikeServerChangeResult(
    val isChange: Boolean,
    val likeId: Long?,
    val boardId: Long?,
    val changedType: Int?,
) {
    companion object {
        fun of(
            isChange: Boolean,
            likeId: Long,
            boardId: Long,
            changedType: Int
        ): LikeServerChangeResult {
            return LikeServerChangeResult(
                isChange = isChange,
                likeId = likeId,
                boardId = boardId,
                changedType = changedType
            )
        }
    }
}
