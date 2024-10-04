package com.example.liveApiServer.entity

import jakarta.persistence.*
import com.example.liveApiServer.enum.BoardType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "boards")
@EntityListeners(AuditingEntityListener::class)
class Board(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var writer: Long,

    @Column(name = "text_content")
    var textContent: String,

    @CreatedDate
    @Column(name = "first_writing_time")
    var firstWritingDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "last_modified_time")
    var lastModifiedDate: LocalDateTime? = null,

    @Column(name = "reading_count")
    var readingCount : Long,

    @Column(name = "like_count")
    var likeCount: Long = 0,

    @Enumerated(EnumType.STRING)
    var type: BoardType,

    @Column(name = "parent_id")
    var parentId: Long? = null,

    )