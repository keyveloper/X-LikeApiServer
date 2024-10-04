package org.example.liveApiServer.controller

import org.example.liveApiServer.dto.ResponseToServerDto
import org.example.liveApiServer.dto.ServerErrorDto
import org.example.liveApiServer.service.LikeService
import org.springframework.http.HttpStatus
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
        val isSaved = likeService.save(boardId, userId)
        if (isSaved) {
            return ResponseEntity.ok().body(
                ResponseToServerDto(
                    error = null,
                    data = null
                )
            )
        }
        return ResponseEntity.ok().body(
            ResponseToServerDto(
                error = ServerErrorDto(
                    type = "baseurl/errors/validation-error",
                    status = HttpStatus.BAD_REQUEST.ordinal,
                    title = "Board are not found or DB server error",
                    detail = "can't add board like count, or DB server error occurred",
                    instance = "baseurl/like"
                ),
                data = null
            )
        )
    }

    @GetMapping("/like/users")
    fun findUsersLikeThisBoard(
        @RequestParam boardId: Long
    ): ResponseEntity<ResponseToServerDto> {
        return ResponseEntity.ok().body(
            ResponseToServerDto(
                error = null,
                data = likeService.findUsersLikeThisBoard(boardId)
            )
        )
    } // 여기는 error 안잡아 줘도 되는지..?

}