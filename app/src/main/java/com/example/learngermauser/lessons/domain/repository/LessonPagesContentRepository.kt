package com.example.learngermauser.lessons.domain.repository

import com.example.learngermauser.lessons.domain.models.LessonPageContent
import kotlinx.coroutines.flow.Flow

interface LessonPagesContentRepository {

    fun getLessonPagesContentByLessonId(lessonId: Long): Flow<List<LessonPageContent>>

    fun insertLessonPagesContent(pagesContent: List<LessonPageContent>)
}
