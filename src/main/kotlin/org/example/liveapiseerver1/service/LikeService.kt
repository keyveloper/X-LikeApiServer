package org.example.liveApiServer.service

import org.example.liveApiServer.dto.UserSummaryDto
import org.example.liveApiServer.entity.Like
import org.example.liveApiServer.execption.UnknownBoardIdException
import org.example.liveApiServer.repository.BoardRepository
import org.example.liveApiServer.repository.LikeRepository
import org.example.liveApiServer.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeService(
    private val likeRepository: LikeRepository,
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository
) {
    private fun updateLikeCountByBoardId(boardId: Long): Boolean {
        return boardRepository.updateLikeCountByBoardId(boardId)
    }

    @Transactional
    fun save(boardId: Long, userId: Long): Boolean{
        if (updateLikeCountByBoardId(boardId)) {
            likeRepository.save(
                    Like(
                        boardId = boardId,
                        userId = userId)
            )
            return true
        } else {
            throw UnknownBoardIdException("Board not found")
        }
    }

    @Transactional(readOnly = true)
    fun findUsersLikeThisBoard(boardId: Long): List<UserSummaryDto>{
        return userRepository.findUserIdsLikeThisBoard(boardId)
            .map { UserSummaryDto.of(it) }
    }
}