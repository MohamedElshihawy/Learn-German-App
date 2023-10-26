package com.example.learngermauser.chapters.domain.models

import androidx.annotation.DrawableRes
import com.example.learngermauser.chapters.data.local.entities.ChapterEntity

data class Chapter(
    val id: Long? = null,
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
) {
    fun toData(): ChapterEntity {
        return ChapterEntity(
            id = this.id,
            title = this.title,
            description = this.description,
            image = this.image,
        )
    }
}
