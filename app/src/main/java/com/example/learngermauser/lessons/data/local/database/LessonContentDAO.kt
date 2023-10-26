package com.example.learngermauser.lessons.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learngermauser.lessons.data.local.entities.LessonPagesContentEntity
import com.example.learngermauser.shared.data.local.database.DataBaseConstants.LESSON_PAGES_CONTENT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonContentDAO {

    @Query("select * from $LESSON_PAGES_CONTENT_TABLE where lessonId =:lessonId")
    fun getLessonPagesContentById(lessonId: Long): Flow<List<LessonPagesContentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLessonPagesContent(pagesContent: List<LessonPagesContentEntity>)
}
