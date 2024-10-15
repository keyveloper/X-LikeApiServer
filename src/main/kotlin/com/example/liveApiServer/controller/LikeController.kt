package com.example.liveApiServer.controller

import com.example.liveApiServer.dto.ResponseToServerDto
import com.example.liveApiServer.service.LikeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeService
) {

    @PostMapping("/live/like")
    fun save(
        @RequestParam boardId: Long,
        @RequestParam userId: Long
    ): ResponseEntity<ResponseToServerDto> {
        likeService.save(boardId, userId)
        return ResponseEntity.ok().body(
            ResponseToServerDto(
                error = null,
                data = null
            )
        )
    }
}