package com.example.learngermauser.lessons.presentaion.lessonContent

import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learngermauser.lessons.domain.useCases.GetLessonPagesContentByLessonIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LessonContentViewModel(
    private val getLessonPagesContentByIdUseCase: GetLessonPagesContentByLessonIdUseCase,
    private val tts: TextToSpeech,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun onEvent(lessonContentEvents: LessonContentEvents) {
        when (lessonContentEvents) {
            is LessonContentEvents.PlayWordPronunciation -> {
                tts.speak(
                    _uiState.value.cards[lessonContentEvents.index].word,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    null,
                )
            }
        }
    }

    fun getLessonPagesContent(id: Long) {
        viewModelScope.launch {
            getLessonPagesContentByIdUseCase(id)
                .collect { lessons ->
                    _uiState.value = _uiState.value.copy(
                        cards = lessons,
                        isLoading = false,
                    )
                }
        }
    }
}
