package com.example.liveApiServer.execption

import com.example.liveApiServer.enum.ServiceServerError

open class LikeApiException(val errorCode: ServiceServerError, message: String): RuntimeException(message)