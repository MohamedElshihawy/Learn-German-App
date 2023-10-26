package com.example.learngermauser.chapters.domain.useCases

import com.example.learngermauser.chapters.domain.repositories.ChapterOperationsRepository

class GetAllChaptersUseCase(
    private val chapterOperationsRepository: ChapterOperationsRepository,
) {
    operator fun invoke() = chapterOperationsRepository.getChapters()
}
