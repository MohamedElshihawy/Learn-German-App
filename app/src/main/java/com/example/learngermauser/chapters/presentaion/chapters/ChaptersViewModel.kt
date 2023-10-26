package com.example.learngermauser.chapters.presentaion.chapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learngermauser.chapters.domain.useCases.GetAllChaptersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChaptersViewModel(
    private val getAllChaptersUseCase: GetAllChaptersUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        viewModelScope.launch {
            getAllChaptersUseCase()
                .collect {
                    _uiState.value = _uiState.value.copy(chapters = it, isLoading = false)
                }
        }
    }
}
