package com.example.learngermauser.lessons.domain.models

import com.example.learngermauser.lessons.data.local.entities.LessonEntity

data class Lesson(
    val id: Long? = null,
    val chapterId: Long,
    val title: String,
    val cover: String? = null,
) {
    fun toData(): LessonEntity {
        return LessonEntity(
            id = this.id,
            chapterId = this.chapterId,
            cover = this.cover,
            title = this.title,
        )
    }
}
