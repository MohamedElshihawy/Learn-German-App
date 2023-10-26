package com.example.learngermauser.lessons.data.local.repository

import com.example.learngermauser.lessons.data.local.database.LessonsDAO
import com.example.learngermauser.lessons.domain.models.Lesson
import com.example.learngermauser.lessons.domain.repository.LessonsOperationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class LessonsOperationsRepositoryImpl(
    private val lessonsDAO: LessonsDAO,
) : LessonsOperationsRepository {

    override fun getAllLessonsByChapterId(chapterId: Long) =
        lessonsDAO.getLessonsByChapterId(chapterId)
            .map { list -> list.map { it.toDomain() } }.flowOn(Dispatchers.IO)

    override fun getAllLessons() =
        lessonsDAO.getAllLessons().map { list -> list.map { it.toDomain() } }.flowOn(Dispatchers.IO)

    override fun insertLessons(lessons: List<Lesson>) {
        lessonsDAO.insertLessons(lessons = lessons.map { it.toData() })
    }
}
