package com.example.learngermauser.lessons.domain.useCases

import com.example.learngermauser.lessons.domain.repository.LessonsOperationsRepository

class GetAllLessonsByChapterIdUseCase(
    private val lessonsOperationsRepository: LessonsOperationsRepository,
) {
    operator fun invoke(chapterId: Long) =
        lessonsOperationsRepository.getAllLessonsByChapterId(chapterId)
}
