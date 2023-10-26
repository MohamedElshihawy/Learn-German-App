package com.example.learngermauser.chapters.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.learngermauser.chapters.data.local.entities.ChapterEntity
import com.example.learngermauser.shared.data.local.database.DataBaseConstants
import kotlinx.coroutines.flow.Flow

@Dao
interface ChaptersDAO {
    @Query("select * from ${DataBaseConstants.CHAPTERS_TABLE}")
    fun getAllChapters(): Flow<List<ChapterEntity>>

    @Query("select * from ${DataBaseConstants.CHAPTERS_TABLE} where id = :id")
    fun getSingleChapter(id: Long): Flow<ChapterEntity>

    @Insert
    fun insertChapters(chapters: List<ChapterEntity>)
}
