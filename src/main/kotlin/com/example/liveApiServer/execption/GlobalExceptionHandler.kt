package com.example.liveApiServer.execption

import com.example.liveApiServer.dto.error.MSAServerErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleBusinessException(ex: BusinessException): ResponseEntity<MSAServerErrorResponse> {
        return ResponseEntity.ok().body(
            MSAServerErrorResponse(
                errorCode = ex.errorCode,
                errorDetails = ex.errorDetails
            )
        )
    }

}