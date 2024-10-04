package org.example.liveApiServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(
    name = "users",
)
@EntityListeners(AuditingEntityListener::class)
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true)
    var email: String,

    @Column(unique = true)
    var username: String,

    @Column(name = "user_img")
    var userImg: String? = null,

    var introduction: String? = null,

    var birthday: LocalDate,

    @CreatedDate
    @Column(name = "first_made_date")
    var firstMadeData: LocalDateTime? = null,

    var country: String? = null,
    )