package com.example.learngermauser.lessons.domain.models

import com.example.learngermauser.lessons.data.local.entities.LessonPagesContentEntity

data class LessonPageContent(
    val id: Long? = null,
    val lessonId: Long,
    val word: String,
    val wordTranslation: String,
    val example: String,
    val exampleTranslation: String,
    val image: String?,
) {
    fun toData(): LessonPagesContentEntity {
        return LessonPagesContentEntity(
            id = this.id,
            image = this.image,
            word = this.word,
            wordTranslation = this.wordTranslation,
            example = this.example,
            exampleTranslation = this.exampleTranslation,
            lessonId = this.lessonId,
        )
    }
}
