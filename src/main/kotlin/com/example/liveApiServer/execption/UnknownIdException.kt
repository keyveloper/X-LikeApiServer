package com.example.liveApiServer.execption

import com.example.liveApiServer.enum.ServiceServerError

class UnknownIdException: LikeApiException(ServiceServerError.UNKNOWN_ID, "Unknown Id.")