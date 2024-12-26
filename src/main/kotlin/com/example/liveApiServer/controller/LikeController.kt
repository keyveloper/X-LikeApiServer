package com.example.liveApiServer.controller

import com.example.liveApiServer.dto.save.request.LikeChangeRequest
import com.example.liveApiServer.dto.save.request.LikeSaveRequest
import com.example.liveApiServer.dto.save.response.LikeServerChangeResponse
import com.example.liveApiServer.dto.save.response.LikeServerSaveResponse
import com.example.liveApiServer.enum.MSAServerErrorCode
import com.example.liveApiServer.service.LikeService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeService,
) {

    @PostMapping("/saveLike")
    fun save(
        @Valid @RequestBody request: LikeSaveRequest
    ): ResponseEntity<LikeServerSaveResponse> {
        likeService.save(request)
        return ResponseEntity.ok().body(
            LikeServerSaveResponse.of(
                errorDetails = null,
                errorCode = MSAServerErrorCode.SUCCESS
            )
        )
    }

    @DeleteMapping("/changeLike")
    fun changeType(
        @Valid @RequestBody request: LikeChangeRequest
    ): ResponseEntity<LikeServerChangeResponse> {
        likeService.changeType(request)
        return ResponseEntity.ok().body(
            LikeServerChangeResponse(
                errorCode = MSAServerErrorCode.SUCCESS,
                errorDetails = null
            )
        )
    }
}