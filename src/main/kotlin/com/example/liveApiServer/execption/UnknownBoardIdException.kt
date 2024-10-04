package com.example.liveApiServer.execption

class UnknownBoardIdException(message: String): RuntimeException(message) {
    fun main() {
        throw UnknownBoardIdException(message!!)
    }
}