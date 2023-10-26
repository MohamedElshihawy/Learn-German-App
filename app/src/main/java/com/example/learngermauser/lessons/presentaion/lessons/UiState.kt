package com.example.learngermauser.lessons.presentaion.lessons

import com.example.learngermauser.lessons.domain.models.Lesson

data class UiState(
    val lessons: List<Lesson> = emptyList(),
    val isLoading: Boolean = true,
)
