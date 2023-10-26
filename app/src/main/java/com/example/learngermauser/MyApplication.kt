package com.example.learngermauser

import android.app.Application
import com.example.learngermauser.chapters.di.chaptersDI
import com.example.learngermauser.chapters.domain.useCases.InsertChaptersUseCase
import com.example.learngermauser.lessons.di.lessonsDI
import com.example.learngermauser.lessons.domain.useCases.InsertLessonPagesContentUseCase
import com.example.learngermauser.lessons.domain.useCases.InsertLessonsUseCase
import com.example.learngermauser.shared.data.initialData.initialChaptersList
import com.example.learngermauser.shared.data.initialData.initialLessonsList
import com.example.learngermauser.shared.data.initialData.pagesContent
import com.example.learngermauser.shared.data.local.preferenceDataStore.AppPreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(chaptersDI, lessonsDI)
            printLogger(level = Level.ERROR)
        }

        val insertChaptersUseCase: InsertChaptersUseCase = get()
        val insertLessonsUseCase: InsertLessonsUseCase = get()
        val insertLessonPagesContentUseCase: InsertLessonPagesContentUseCase = get()
        val appPreference: AppPreferenceManager = get()

        CoroutineScope(Dispatchers.IO).launch {
            if (appPreference.isFirstTimeLaunch.first()) {
                insertChaptersUseCase(chapters = initialChaptersList)
                insertLessonsUseCase(lessons = initialLessonsList)
                insertLessonPagesContentUseCase(pagesContent = pagesContent)
                appPreference.setFirstTimeLaunch(false)
            }
        }
    }
}
