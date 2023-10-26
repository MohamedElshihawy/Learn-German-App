package com.example.learngermauser.lessons.data.local.repository

import com.example.learngermauser.lessons.data.local.database.LessonContentDAO
import com.example.learngermauser.lessons.domain.models.LessonPageContent
import com.example.learngermauser.lessons.domain.repository.LessonPagesContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class LessonPagesContentRepositoryImpl(
    private val lessonPagesContentDAO: LessonContentDAO,
) : LessonPagesContentRepository {
    override fun getLessonPagesContentByLessonId(lessonId: Long) =
        lessonPagesContentDAO.getLessonPagesContentById(lessonId)
            .map { lessons -> lessons.map { it.toDomain() } }.flowOn(Dispatchers.IO)

    override fun insertLessonPagesContent(pagesContent: List<LessonPageContent>) =
        lessonPagesContentDAO.insertLessonPagesContent(pagesContent.map { it.toData() })
}
