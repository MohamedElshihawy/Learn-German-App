package com.example.learngermauser.lessons.domain.useCases

import com.example.learngermauser.lessons.domain.repository.LessonsOperationsRepository

class GetAllLessonsUseCase(private val lessonsOperationsRepository: LessonsOperationsRepository) {

    operator fun invoke() = lessonsOperationsRepository.getAllLessons()
}
