package org.example.liveApiServer.dto

import org.example.liveApiServer.entity.User

data class UserSummaryDto(
    val username: String,
    val userImg: String?,
) {
    companion object {
        fun of(user: User): UserSummaryDto {
            return UserSummaryDto(
                username = user.username,
                userImg = user.userImg,
            )
        }
    }
}
