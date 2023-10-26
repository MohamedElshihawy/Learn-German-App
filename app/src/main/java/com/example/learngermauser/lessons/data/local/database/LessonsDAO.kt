package com.example.learngermauser.lessons.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learngermauser.lessons.data.local.entities.LessonEntity
import com.example.learngermauser.shared.data.local.database.DataBaseConstants.LESSONS_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonsDAO {
    @Query("select * from $LESSONS_TABLE where chapterId = :chapterId")
    fun getLessonsByChapterId(chapterId: Long): Flow<List<LessonEntity>>

    @Query("select * from $LESSONS_TABLE")
    fun getAllLessons(): Flow<List<LessonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLessons(lessons: List<LessonEntity>)
}
