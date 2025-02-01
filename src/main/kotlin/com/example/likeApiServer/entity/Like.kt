package com.example.likeApiServer.entity

import com.example.likeApiServer.enum.LikeType
import jakarta.persistence.*

@Entity
@Table(
    name = "likes",
    uniqueConstraints = [UniqueConstraint(columnNames = ["boardId", "userId"])],
    indexes = [
        Index(name = "idx_boardId", columnList = "boardId"),
        Index(name = "idx_userId", columnList = "userId")
    ]
)
class Like(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    val boardId: Long,

    val userId: Long,

    var likeType: LikeType
)