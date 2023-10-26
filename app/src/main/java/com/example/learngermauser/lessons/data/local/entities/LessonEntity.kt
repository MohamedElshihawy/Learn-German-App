package com.example.learngermauser.lessons.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learngermauser.lessons.domain.models.Lesson
import com.example.learngermauser.shared.data.local.database.DataBaseConstants.LESSONS_TABLE

@Entity(tableName = LESSONS_TABLE)
data class LessonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val chapterId: Long,
    val title: String,
    val cover: String? = null,
) {
    fun toDomain(): Lesson {
        return Lesson(
            id = this.id,
            chapterId = this.chapterId,
            cover = this.cover,
            title = this.title,
        )
    }
}
