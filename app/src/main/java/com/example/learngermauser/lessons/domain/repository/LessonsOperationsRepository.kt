package com.example.learngermauser.lessons.domain.repository

import com.example.learngermauser.lessons.domain.models.Lesson
import kotlinx.coroutines.flow.Flow

interface LessonsOperationsRepository {

    fun getAllLessonsByChapterId(chapterId: Long): Flow<List<Lesson>>
    fun getAllLessons(): Flow<List<Lesson>>
    fun insertLessons(lessons: List<Lesson>)
}
