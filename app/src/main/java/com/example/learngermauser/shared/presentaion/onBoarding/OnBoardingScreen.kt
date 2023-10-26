package com.example.learngermauser.shared.presentaion.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learngermauser.shared.navigation.Screen
import com.example.learngermauser.shared.presentaion.onBoarding.components.BoardingColoredButton
import com.example.learngermauser.shared.presentaion.onBoarding.components.BoardingTextButton
import com.example.learngermauser.shared.presentaion.onBoarding.components.OnBoardingPage
import com.example.learngermauser.shared.presentaion.onBoarding.components.PageIndicator
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = get(),
    navController: NavController,
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Get Started")
                else -> listOf("")
            }
        }
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier
            .fillMaxSize(),
    ) {
        HorizontalPager(state = pagerState) { page ->
            OnBoardingPage(page = pages[page])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PageIndicator(
                numOfPages = pagerState.pageCount,
                selectedPage = pagerState.currentPage,
                modifier = Modifier.width(60.dp),
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (buttonState.value[0].isNotEmpty()) {
                    BoardingTextButton(text = buttonState.value[0]) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                }

                BoardingColoredButton(text = buttonState.value[1]) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            viewModel.setDisplayedOnBoarding()
                            navController.navigate(Screen.ChaptersScreen.route)
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            }
        }
    }
}
