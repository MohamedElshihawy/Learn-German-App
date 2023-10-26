package com.example.learngermauser.chapters.data.local.entities

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learngermauser.chapters.domain.models.Chapter
import com.example.learngermauser.shared.data.local.database.DataBaseConstants.CHAPTERS_TABLE

@Entity(tableName = CHAPTERS_TABLE)
data class ChapterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
) {
    fun toDomain(): Chapter {
        return Chapter(
            id = this.id,
            title = this.title,
            description = this.description,
            image = this.image,
        )
    }
}
