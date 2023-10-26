package com.example.learngermauser.chapters.domain.useCases

import com.example.learngermauser.chapters.domain.models.Chapter
import com.example.learngermauser.chapters.domain.repositories.ChapterOperationsRepository

class InsertChaptersUseCase(
    private val chapterOperationsRepository: ChapterOperationsRepository,
) {
    operator fun invoke(chapters: List<Chapter>) =
        chapterOperationsRepository.insertChapters(chapters)
}
