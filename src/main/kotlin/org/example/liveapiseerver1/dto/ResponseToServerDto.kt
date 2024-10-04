package org.example.liveApiServer.dto

data class ResponseToServerDto(
    val error: ServerErrorDto?,
    val data: Any?
)