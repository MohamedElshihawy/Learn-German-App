package com.example.learngermauser.lessons.di

import com.example.learngermauser.lessons.data.local.repository.LessonPagesContentRepositoryImpl
import com.example.learngermauser.lessons.data.local.repository.LessonsOperationsRepositoryImpl
import com.example.learngermauser.lessons.domain.repository.LessonPagesContentRepository
import com.example.learngermauser.lessons.domain.repository.LessonsOperationsRepository
import com.example.learngermauser.lessons.domain.useCases.GetAllLessonsByChapterIdUseCase
import com.example.learngermauser.lessons.domain.useCases.GetAllLessonsUseCase
import com.example.learngermauser.lessons.domain.useCases.GetLessonPagesContentByLessonIdUseCase
import com.example.learngermauser.lessons.domain.useCases.InsertLessonPagesContentUseCase
import com.example.learngermauser.lessons.domain.useCases.InsertLessonsUseCase
import com.example.learngermauser.lessons.presentaion.lessonContent.LessonContentViewModel
import com.example.learngermauser.lessons.presentaion.lessons.LessonsViewModel
import com.example.learngermauser.shared.di.sharedDi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val lessonsDI = module {

    includes(sharedDi)

    single<LessonsOperationsRepository> {
        LessonsOperationsRepositoryImpl(get())
    }

    single<LessonPagesContentRepository> {
        LessonPagesContentRepositoryImpl(get())
    }

    single {
        GetAllLessonsUseCase(get())
    }

    single {
        GetAllLessonsByChapterIdUseCase(get())
    }

    single {
        InsertLessonsUseCase(get())
    }

    single {
        InsertLessonPagesContentUseCase(get())
    }

    single {
        GetLessonPagesContentByLessonIdUseCase(get())
    }

    viewModel {
        LessonsViewModel(get())
    }

    viewModel {
        LessonContentViewModel(get(), get())
    }
}
