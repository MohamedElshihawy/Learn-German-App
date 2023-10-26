package com.example.learngermauser.shared.presentaion.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learngermauser.shared.data.local.preferenceDataStore.AppPreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val appPreferenceManager: AppPreferenceManager,
) : ViewModel() {

    fun setDisplayedOnBoarding() {
        viewModelScope.launch(Dispatchers.IO) {
            appPreferenceManager.setOnBoardingDisplayed(true)
        }
    }
}
