package com.example.likeApiServer.service

import com.example.likeApiServer.dto.error.MSAServerErrorDetails
import com.example.likeApiServer.dto.request.LikeChangeRequest
import com.example.likeApiServer.dto.response.LikeServerChangeResult
import com.example.likeApiServer.dto.request.LikeSaveRequest
import com.example.likeApiServer.dto.response.LikeServerCountResult
import com.example.likeApiServer.dto.response.LikeServerSaveResult
import com.example.likeApiServer.entity.Like
import com.example.likeApiServer.enum.MSAServerErrorCode
import com.example.likeApiServer.execption.BusinessException
import com.example.likeApiServer.execption.DuplicatedIdException
import com.example.likeApiServer.execption.NotFoundEntityException
import com.example.likeApiServer.repository.LikeRepository
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class LikeService(
    private val likeRepository: LikeRepository,
) {
    fun save(request: LikeSaveRequest): LikeServerSaveResult {
        return try {
            val newEntity = likeRepository.save(
                Like(
                    id = null, // 이렇게 명시하는게 좋아.
                    boardId = request.boardId,
                    userId = request.userId,
                    type = request.likeType,
                )
            )
            LikeServerSaveResult.of(isSave = true, newEntity)
            // isSave is always true...

        } catch(ex: DataIntegrityViolationException) {
            val rootCause = ex.rootCause
            if (rootCause is ConstraintViolationException) {
                if (rootCause.message?.contains("duplicated") == true) {
                    throw DuplicatedIdException(
                        errorDetails = MSAServerErrorDetails(
                            url = "",
                            status = HttpStatus.BAD_REQUEST,
                            title = "duplicated Id",
                            detail = "${rootCause.message}"
                        )
                    )
                } else {
                    throw BusinessException(
                        errorCode = MSAServerErrorCode.UNKNOWN_ERROR,
                        errorDetails = MSAServerErrorDetails(
                            url = "/saveLike",
                            status = HttpStatus.BAD_REQUEST,
                            title = "unknow business error",
                            detail = "Data integrity violation error, but not defined!" +
                                    "${rootCause.message}"
                        )
                    )
                }
            } else {
                throw BusinessException(
                    errorCode = MSAServerErrorCode.UNKNOWN_ERROR,
                    errorDetails = MSAServerErrorDetails(
                        url = "/saveLike",
                        status = HttpStatus.BAD_REQUEST,
                        title = "unknow business error",
                        detail = "Data integrity violation error, but not defined!" +
                                "${rootCause?.message}"
                    )
                )
            }
        }
    }

    fun changeType(request: LikeChangeRequest): LikeServerChangeResult {
        // 1. check board
        val like: Like = likeRepository.findByUserIDAndBoardId(
            request.boardId,
            request.userId
        ) ?: throw NotFoundEntityException(
            errorDetails = MSAServerErrorDetails(
                url = "/changeLike",
                status = HttpStatus.NOT_FOUND,
                title = "not found Entity",
                detail = "can't find entity\n(userId, boardId): ${request.userId}, ${request.boardId}"
            )
        )

        like.type = request.type // 자동 없데이트

        val changedLike = likeRepository.save(like)
        return LikeServerChangeResult.of(
            isChange = true,
            likeId = changedLike.id!!,
            boardId = changedLike.boardId,
            changedType = changedLike.type.code
        )
    }

    fun countLikes(targetBoardId: Long): LikeServerCountResult {
        return LikeServerCountResult.of(
            targetBoardId = targetBoardId,
            totalCount = likeRepository.countLikes(targetBoardId)
        )
    }
}