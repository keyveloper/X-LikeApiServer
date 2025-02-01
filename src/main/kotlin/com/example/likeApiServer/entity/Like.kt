package com.example.likeApiServer.entity

import com.example.likeApiServer.enum.LikeType
import jakarta.persistence.*

@Entity
@Table(name = "likes")
class Like(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    val boardId: Long,

    val userId: Long,

    var type: LikeType
)