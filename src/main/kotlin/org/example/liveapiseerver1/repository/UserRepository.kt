package org.example.liveApiServer.repository

import org.example.liveApiServer.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>, UserQueryDslRepository {
}