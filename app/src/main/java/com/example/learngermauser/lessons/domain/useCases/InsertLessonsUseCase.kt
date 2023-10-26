package com.example.learngermauser.lessons.domain.useCases

import com.example.learngermauser.lessons.domain.models.Lesson
import com.example.learngermauser.lessons.domain.repository.LessonsOperationsRepository

class InsertLessonsUseCase(
    private val lessonsOperationsRepository: LessonsOperationsRepository,
) {

    operator fun invoke(lessons: List<Lesson>) = lessonsOperationsRepository.insertLessons(lessons)
}
