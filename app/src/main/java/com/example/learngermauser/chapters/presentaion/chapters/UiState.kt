package com.example.learngermauser.chapters.presentaion.chapters

import com.example.learngermauser.chapters.domain.models.Chapter

data class UiState(
    val chapters: List<Chapter> = emptyList(),
    val isLoading: Boolean = true,
)
