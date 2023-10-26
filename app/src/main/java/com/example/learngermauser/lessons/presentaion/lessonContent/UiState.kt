package com.example.learngermauser.lessons.presentaion.lessonContent

import com.example.learngermauser.lessons.domain.models.LessonPageContent

data class UiState(
    val cards: List<LessonPageContent> = emptyList(),
    val isLoading: Boolean = true,
)
