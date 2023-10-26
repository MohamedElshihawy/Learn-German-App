package com.example.learngermauser.chapters.di

import com.example.learngermauser.chapters.data.local.repository.ChapterOperationsRepositoryImpl
import com.example.learngermauser.chapters.domain.repositories.ChapterOperationsRepository
import com.example.learngermauser.chapters.domain.useCases.GetAllChaptersUseCase
import com.example.learngermauser.chapters.domain.useCases.InsertChaptersUseCase
import com.example.learngermauser.chapters.presentaion.chapters.ChaptersViewModel
import com.example.learngermauser.shared.di.sharedDi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chaptersDI = module {

    includes(sharedDi)

    single<ChapterOperationsRepository> {
        ChapterOperationsRepositoryImpl(get())
    }

    single {
        GetAllChaptersUseCase(get())
    }

    single {
        GetAllChaptersUseCase(get())
    }

    single {
        InsertChaptersUseCase(get())
    }

    viewModel {
        ChaptersViewModel(get())
    }
}
