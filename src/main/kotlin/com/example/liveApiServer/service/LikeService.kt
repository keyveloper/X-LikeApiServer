package com.example.liveApiServer.service

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.dto.save.request.LikeChangeRequest
import com.example.liveApiServer.dto.save.request.LikeChangeResult
import com.example.liveApiServer.dto.save.request.LikeSaveRequest
import com.example.liveApiServer.entity.Like
import com.example.liveApiServer.enum.MSAServerErrorCode
import com.example.liveApiServer.execption.BusinessException
import com.example.liveApiServer.execption.DuplicatedIdException
import com.example.liveApiServer.execption.NotFoundEntityException
import com.example.liveApiServer.repository.LikeRepository
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.servlet.View

@Service
class LikeService(
    private val likeRepository: LikeRepository,
) {
    fun save(request: LikeSaveRequest): Long{
        return try {
            return likeRepository.save(
                Like(
                    id = null, // 이렇게 명시하는게 좋아.
                    boardId = request.boardId,
                    userId = request.userId,
                    likeType = request.likeType,
                )
            ).id!!

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

    fun changeType(request: LikeChangeRequest): LikeChangeResult{

        // 1. check board
        val like: Like = likeRepository.findByUserIDAndBoardId(
            request.boardId,
            request.userId
        ) ?: throw NotFoundEntityException(
            errorDetails = MSAServerErrorDetails(
                url = "/changeLike",
                status = HttpStatus.NOT_FOUND,
                title = "not found Entity",
                detail = "can't find entity\n(userID, boardId): ${request.userId}, ${request.boardId}"
            )
        )

        like.likeType = request.type // 자동 없데이트

        val changedLike = likeRepository.save(like)
        return LikeChangeResult(
            true,
            changedLike.id!!,
            changedLike.likeType
        )
    }
}