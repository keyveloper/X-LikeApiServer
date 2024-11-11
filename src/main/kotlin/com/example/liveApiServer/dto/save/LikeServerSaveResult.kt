package com.example.liveApiServer.dto.save

import com.example.liveApiServer.dto.ServerErrorDetails
import com.example.liveApiServer.enum.ServiceServerError

data class LikeServerSaveResult(
    val details: ServerErrorDetails?,
    val error: ServiceServerError?,
)