package com.example.learngermauser.lessons.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learngermauser.lessons.domain.models.LessonPageContent
import com.example.learngermauser.shared.data.local.database.DataBaseConstants.LESSON_PAGES_CONTENT_TABLE

@Entity(tableName = LESSON_PAGES_CONTENT_TABLE)
data class LessonPagesContentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val lessonId: Long,
    val word: String,
    val wordTranslation: String,
    val example: String,
    val exampleTranslation: String,
    val image: String?,
) {
    fun toDomain(): LessonPageContent {
        return LessonPageContent(
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
