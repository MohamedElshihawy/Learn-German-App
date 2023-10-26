package com.example.learngermauser.lessons.presentaion.lessonContent

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learngermauser.R
import com.example.learngermauser.lessons.presentaion.lessonContent.components.LessonContentCard
import com.example.learngermauser.lessons.presentaion.lessons.components.ExampleContainer
import org.koin.androidx.compose.get

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LessonContentScreen(
    modifier: Modifier = Modifier,
    lessonId: Long,
    viewModel: LessonContentViewModel = get(),
    navController: NavController,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getLessonPagesContent(lessonId)
    }
    val uiState by viewModel.uiState.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
    ) {
        uiState.cards.size
    }
    val pageOffset = derivedStateOf { pagerState.currentPageOffsetFraction }

    val exampleData by derivedStateOf {
        val currentPage = pagerState.currentPage
        val example = uiState.cards.getOrNull(currentPage)?.example
        val exampleTranslation = uiState.cards.getOrNull(currentPage)?.exampleTranslation
        Pair(example, exampleTranslation)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.lesson),
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = "back",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                            .padding(start = 16.dp),
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column(modifier = modifier.fillMaxWidth()) {
                    HorizontalPager(
                        state = pagerState,
                        contentPadding = PaddingValues(32.dp),
                        modifier = Modifier
                            .height(350.dp)
                            .weight(1f),
                    ) { page ->
                        if (uiState.cards.isNotEmpty()) {
                            LessonContentCard(
                                lessonPage = uiState.cards[page],
                                pageOffset = pageOffset.value,
                                onCardClick = {
                                    viewModel.onEvent(
                                        LessonContentEvents.PlayWordPronunciation(
                                            page,
                                        ),
                                    )
                                },
                            )
                        }
                    }

                    if (uiState.cards.isNotEmpty()) {
                        ExampleContainer(
                            example = exampleData.first!!,
                            translation = exampleData.second!!,
                        )
                    }
                }
            }
        }
    }
}
