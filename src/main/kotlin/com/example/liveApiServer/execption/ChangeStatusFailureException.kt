package com.example.liveApiServer.execption

import com.example.liveApiServer.enum.ServiceServerError

class ChangeStatusFailureException: LikeApiException(ServiceServerError.LIKE_CHANGE_FAILURE, "Like status not changed")