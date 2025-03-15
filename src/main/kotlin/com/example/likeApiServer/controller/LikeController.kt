package com.example.likeApiServer.controller

import com.example.likeApiServer.dto.request.LikeChangeRequest
import com.example.likeApiServer.dto.request.LikeCountGetRequest
import com.example.likeApiServer.dto.request.LikeSaveRequest
import com.example.likeApiServer.dto.response.LikeServerCountResponse
import com.example.likeApiServer.dto.save.response.LikeServerChangeResponse
import com.example.likeApiServer.dto.save.response.LikeServerSaveResponse
import com.example.likeApiServer.enum.MSAServerErrorCode
import com.example.likeApiServer.service.LikeService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeService,
) {

    @PostMapping("/saveLike")
    fun save(
        @Valid @RequestBody request: LikeSaveRequest
    ): ResponseEntity<LikeServerSaveResponse> {
        val result = likeService.save(request)
        return ResponseEntity.ok().body(
            LikeServerSaveResponse.of(
                result,
                errorDetails = null,
                errorCode = MSAServerErrorCode.SUCCESS.code
            )
        )
    }

    @PostMapping("/changeLike")
    fun changeType(
        @Valid @RequestBody request: LikeChangeRequest
    ): ResponseEntity<LikeServerChangeResponse> {
        val result = likeService.changeType(request)
        return ResponseEntity.ok().body(
            LikeServerChangeResponse.of(
                result = result,
                errorCode = MSAServerErrorCode.SUCCESS,
                errorDetails = null
            )
        )
    }

    @PostMapping("/countLikes")
    fun countLikes(
        @Valid @RequestBody request: LikeCountGetRequest
    ): ResponseEntity<LikeServerCountResponse> {
        return ResponseEntity.ok().body(
            LikeServerCountResponse.of(
                result = likeService.countLikes(request.targetBoardId),
                errorCode = MSAServerErrorCode.SUCCESS.code,
                errorDetails = null
            )
        )
    }
}