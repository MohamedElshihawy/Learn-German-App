package com.example.learngermauser.lessons.presentaion.lessonContent

sealed class LessonContentEvents {

    class PlayWordPronunciation(val index: Int) : LessonContentEvents()
}
