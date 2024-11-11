package com.example.liveApiServer.controller

import com.example.liveApiServer.dto.LikeRequest
import com.example.liveApiServer.dto.LikeServerSaveResponse
import com.example.liveApiServer.dto.save.LikeRequest
import com.example.liveApiServer.dto.save.LikeServerSaveResponse
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

    @PostMapping("/like")
    fun save(
        @Valid @RequestBody request: LikeRequest
    ): ResponseEntity<LikeServerSaveResponse> {
        return ResponseEntity.ok().body(
            LikeServerSaveResponse.of(
                likeService.save(request)
            )
        )
    }

    @DeleteMapping("/like")
    fun delete(
        @RequestBody boardId: Long
    ): ResponseEntity<LikeServerSaveResponse> {
        likeService.delete(boardId)
        return ResponseEntity.ok().body(
            LikeServerSaveResponse(
                error = null,
                userIds = null
            )
        )
    }

    @GetMapping("/like/users")
    fun findUserIdsByBoardId(
        @RequestParam boardId: Long,
    ): ResponseEntity<LikeServerSaveResponse> {
        return ResponseEntity.ok().body(
            LikeServerSaveResponse(
                error = null,
                userIds = likeService.findUserIdsByBoardId(boardId)
            )
        )
    }
}