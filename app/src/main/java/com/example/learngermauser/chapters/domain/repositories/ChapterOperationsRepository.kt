package com.example.learngermauser.chapters.domain.repositories

import com.example.learngermauser.chapters.domain.models.Chapter
import kotlinx.coroutines.flow.Flow

interface ChapterOperationsRepository {

    fun getChapters(): Flow<List<Chapter>>

    fun getSingleChapter(id: Long): Flow<Chapter>

    fun insertChapters(chapters: List<Chapter>)
}
