package com.example.learngermauser.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learngermauser.chapters.presentaion.chapters.ChaptersScreen
import com.example.learngermauser.lessons.presentaion.lessonContent.LessonContentScreen
import com.example.learngermauser.lessons.presentaion.lessons.LessonsScreen
import com.example.learngermauser.shared.presentaion.onBoarding.OnBoardingScreen
import com.example.learngermauser.shared.presentaion.splash.SplashScreen

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavGraph(
        modifier = modifier,
        navController = navController,
    )
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(route = Screen.ChaptersScreen.route) {
            ChaptersScreen(
                navController = navController,
                modifier = modifier,
            )
        }

        composable(
            route = Screen.LessonsScreen.route + "/{chapterId}",
            arguments = listOf(
                navArgument(name = "chapterId") {
                    type = NavType.LongType
                    defaultValue = 0
                },
            ),
        ) { backStack ->
            val chapterId = backStack.arguments?.getLong("chapterId")
            LessonsScreen(navController = navController, chapterId = chapterId!!)
        }

        composable(
            route = Screen.LessonContentScreen.route + "/{lessonId}",
            arguments = listOf(
                navArgument(name = "lessonId") {
                    type = NavType.LongType
                    defaultValue = 0
                },
            ),
        ) { backStack ->
            val lessonId = backStack.arguments?.getLong("lessonId")
            LessonContentScreen(navController = navController, lessonId = lessonId!!)
        }
    }
}
