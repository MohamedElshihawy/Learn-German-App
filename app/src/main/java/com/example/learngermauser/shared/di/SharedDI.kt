package com.example.learngermauser.shared.di

import com.example.learngermauser.shared.data.local.database.AppDatabase
import com.example.learngermauser.shared.data.local.preferenceDataStore.AppPreferenceManager
import com.example.learngermauser.shared.domain.utils.TextToSpeechSetUp.newInstanceTTS
import com.example.learngermauser.shared.presentaion.onBoarding.OnboardingViewModel
import com.example.learngermauser.shared.presentaion.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedDi = module {

    single {
        AppDatabase.getDatabase(androidApplication())
    }

    single {
        get<AppDatabase>().chaptersDao()
    }

    single {
        get<AppDatabase>().lessonsDao()
    }

    single {
        get<AppDatabase>().lessonPagesContentDao()
    }

    single {
        newInstanceTTS(context = androidContext())
    }

    single {
        AppPreferenceManager(androidContext())
    }

    viewModel {
        SplashViewModel(get())
    }

    viewModel {
        OnboardingViewModel(get())
    }
}
