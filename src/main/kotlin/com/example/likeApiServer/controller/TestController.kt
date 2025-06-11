package com.example.likeApiServer.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test/front-connection")
    fun testConnection(): ResponseEntity<String> {
        return ResponseEntity.ok("Connection Success!!")
    }
}