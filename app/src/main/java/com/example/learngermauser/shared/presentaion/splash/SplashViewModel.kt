package com.example.learngermauser.shared.presentaion.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learngermauser.shared.data.local.preferenceDataStore.AppPreferenceManager
import com.example.learngermauser.shared.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val appPreferenceManager: AppPreferenceManager,
) : ViewModel() {

    private val _nextDestination = MutableStateFlow("")
    val nextDestination: StateFlow<String> = _nextDestination
    private val _finishedLoading = MutableStateFlow(false)
    val finishedLoading = _finishedLoading

    init {
        viewModelScope.launch(Dispatchers.IO) {
            appPreferenceManager.isOnBoardingDisplayedBefore.collect { displayedBefore ->
                if (displayedBefore) {
                    _nextDestination.value = Screen.ChaptersScreen.route
                } else {
                    _nextDestination.value = Screen.OnBoardingScreen.route
                }
                _finishedLoading.value = true
            }
        }
    }
}
