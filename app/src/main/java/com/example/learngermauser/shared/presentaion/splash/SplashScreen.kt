package com.example.learngermauser.shared.presentaion.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learngermauser.R
import com.example.learngermauser.shared.navigation.Screen
import org.koin.androidx.compose.get

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = get(),
    navController: NavController,
) {
    val nextDestination = viewModel.nextDestination.collectAsState()
    val finishedLoading = viewModel.finishedLoading.collectAsState()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "",
            modifier = modifier.size(200.dp),
        )
    }
    if (finishedLoading.value) {
        navController.navigate(nextDestination.value) {
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }
}
