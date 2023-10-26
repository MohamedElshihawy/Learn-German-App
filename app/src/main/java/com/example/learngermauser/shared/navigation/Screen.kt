package com.example.learngermauser.shared.navigation

sealed class Screen(val route: String) {

    data object SplashScreen : Screen(route = "splash_screen")
    data object OnBoardingScreen : Screen(route = "onBoardingScreen")
    data object ChaptersScreen : Screen(route = "chapters_screen")
    data object LessonsScreen : Screen(route = "lessons_screen")
    data object LessonContentScreen : Screen(route = "lesson_content_screen")
}
