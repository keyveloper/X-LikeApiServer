package com.example.liveApiServer.entity

import com.example.liveApiServer.enum.LikeType
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
    var id: Long? = null,

    @Column(name = "board_id")
    val boardId: Long,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "like_type")
    val likeType: LikeType
)