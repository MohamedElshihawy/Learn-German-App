package com.example.learngermauser.lessons.domain.useCases

import com.example.learngermauser.lessons.domain.repository.LessonPagesContentRepository

class GetLessonPagesContentByLessonIdUseCase(
    private val lessonPagesContentRepository: LessonPagesContentRepository,
) {
    operator fun invoke(lessonId: Long) =
        lessonPagesContentRepository.getLessonPagesContentByLessonId(lessonId)
}
