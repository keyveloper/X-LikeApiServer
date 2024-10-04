package org.example.liveApiServer.execption

class UnknownUserIdException(message: String): RuntimeException(message) {
    fun main() {
        throw UnknownUserIdException(message!!)
    }
}