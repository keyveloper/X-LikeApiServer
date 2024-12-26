package com.example.liveApiServer.enum

import com.example.liveApiServer.dto.error.MSAServerErrorDetails
import com.example.liveApiServer.execption.UndefinedLikeType
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus

enum class LikeType(val code: Int) {
    NONE(0),

    LIKE(1),

    SMILE(2),

    SAD(3),

    AMAZING(4);

    @JsonValue
    fun toValue(): Int {
        return code
    }

    companion object {
        @JsonCreator
        @JvmStatic
        fun fromValue(value: Int): LikeType {
            return entries.find {it.code == value}
                ?: throw UndefinedLikeType(
                    errorDetails = MSAServerErrorDetails(
                        url = "changeLike",
                        status = HttpStatus.BAD_REQUEST,
                        title = "undifined like type",
                        detail = "you are trying to change undifiend like type..."
                    )
                )

        }
    }
}