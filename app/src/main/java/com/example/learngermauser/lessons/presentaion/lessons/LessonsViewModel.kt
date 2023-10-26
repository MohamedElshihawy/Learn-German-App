package com.example.learngermauser.lessons.presentaion.lessons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learngermauser.lessons.domain.useCases.GetAllLessonsByChapterIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LessonsViewModel(
    private val getAllLessonsByChapterIdUseCase: GetAllLessonsByChapterIdUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState> = _uiState

    fun getAllLessonByChapterId(id: Long) {
        viewModelScope.launch {
            getAllLessonsByChapterIdUseCase(id)
                .collect {
                    _uiState.value = _uiState.value.copy(lessons = it, isLoading = false)
                }
        }
    }
}
