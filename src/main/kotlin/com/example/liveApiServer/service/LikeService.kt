package com.example.liveApiServer.service

import com.example.liveApiServer.dto.UserSummaryDto
import com.example.liveApiServer.entity.Like
import com.example.liveApiServer.execption.UnknownBoardIdException
import com.example.liveApiServer.repository.BoardRepository
import com.example.liveApiServer.repository.LikeRepository
import com.example.liveApiServer.repository.UserRepository
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