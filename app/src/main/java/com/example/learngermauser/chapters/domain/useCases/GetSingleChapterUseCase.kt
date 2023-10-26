package com.example.learngermauser.chapters.domain.useCases

import com.example.learngermauser.chapters.domain.repositories.ChapterOperationsRepository

class GetSingleChapterUseCase(
    private val chapterOperationsRepository: ChapterOperationsRepository,
) {
    operator fun invoke(id: Long) = chapterOperationsRepository.getSingleChapter(id)
}
