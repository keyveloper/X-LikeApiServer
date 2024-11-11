package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.ServerErrorDetails
import com.example.liveApiServer.dto.save.LikeServerSaveResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleLikeApiException(ex: LikeApiException): ResponseEntity<LikeServerSaveResponse> {
        return ResponseEntity.ok().body(
            LikeServerSaveResponse(
            )
        )
    }

}