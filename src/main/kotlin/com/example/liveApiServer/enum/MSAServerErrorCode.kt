package com.example.liveApiServer.enum

enum class MSAServerErrorCode(val code: Int) {
    SUCCESS(1),
    UNKNOWN_ERROR(9999),

    // DB integrity
    DUPLICATED_ID(10000),
    INVALID_ID(10001),

    // Valid
    NOT_NULL(20000),
    NOT_BLANK(20001),
    NOT_PATTERN(20002),
    AUTHENTICATION_ERROR(20003),

    // undefined type(enum)
    UNDEFINED_TYPE(30000);

    companion object {
        /**
         * 숫자 에러 코드로부터 MSAServerErrorCode를 반환합니다.
         * 매칭되지 않는 경우 null을 반환합니다.
         */
        fun fromCode(code: Int): MSAServerErrorCode? =
            entries.find { it.code == code }
    }
}