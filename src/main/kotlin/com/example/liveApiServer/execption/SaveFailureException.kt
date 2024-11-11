package com.example.liveApiServer.execption

import com.example.liveApiServer.enum.ServiceServerError

class SaveFailureException: LikeApiException(ServiceServerError.SAVE_FAILURE, "like failure") {
}