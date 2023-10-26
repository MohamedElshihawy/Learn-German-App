package com.example.learngermauser.lessons.domain.useCases

import com.example.learngermauser.lessons.domain.models.LessonPageContent
import com.example.learngermauser.lessons.domain.repository.LessonPagesContentRepository

class InsertLessonPagesContentUseCase(
    private val lessonPagesContentRepository: LessonPagesContentRepository,
) {
    operator fun invoke(pagesContent: List<LessonPageContent>) =
        lessonPagesContentRepository.insertLessonPagesContent(pagesContent = pagesContent)
}
