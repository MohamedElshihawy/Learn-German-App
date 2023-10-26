package com.example.learngermauser.shared.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.learngermauser.chapters.data.local.database.ChaptersDAO
import com.example.learngermauser.chapters.data.local.entities.ChapterEntity
import com.example.learngermauser.lessons.data.local.database.LessonContentDAO
import com.example.learngermauser.lessons.data.local.database.LessonsDAO
import com.example.learngermauser.lessons.data.local.entities.LessonEntity
import com.example.learngermauser.lessons.data.local.entities.LessonPagesContentEntity

@Database(
    entities = [LessonEntity::class, ChapterEntity::class, LessonPagesContentEntity::class],
    version = 2,
    exportSchema = false,
)
@TypeConverters(DrawableResConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun chaptersDao(): ChaptersDAO
    abstract fun lessonsDao(): LessonsDAO
    abstract fun lessonPagesContentDao(): LessonContentDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
