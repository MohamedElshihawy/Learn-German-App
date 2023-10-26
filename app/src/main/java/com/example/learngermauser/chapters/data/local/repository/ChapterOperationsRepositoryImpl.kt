package com.example.learngermauser.chapters.data.local.repository

import com.example.learngermauser.chapters.data.local.database.ChaptersDAO
import com.example.learngermauser.chapters.domain.models.Chapter
import com.example.learngermauser.chapters.domain.repositories.ChapterOperationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class ChapterOperationsRepositoryImpl(private val chaptersDAO: ChaptersDAO) :
    ChapterOperationsRepository {

    override fun getChapters() =
        chaptersDAO.getAllChapters().map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    override fun getSingleChapter(id: Long) =
        chaptersDAO.getSingleChapter(id).map { it.toDomain() }.flowOn(Dispatchers.IO)

    override fun insertChapters(chapters: List<Chapter>) {
        chaptersDAO.insertChapters(chapters.map { it.toData() })
    }
}
