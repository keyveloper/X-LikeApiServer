package com.example.liveApiServer.repository

import com.example.liveApiServer.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>, UserQueryDslRepository {
}