package com.example.learngermauser.lessons.presentaion.lessonContent.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.learngermauser.lessons.domain.models.LessonPageContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonContentCard(
    modifier: Modifier = Modifier,
    lessonPage: LessonPageContent,
    pageOffset: Float,
    onCardClick: () -> Unit,
) {
    ElevatedCard(
        onClick = {
            onCardClick()
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp, pressedElevation = 12.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp)
            .graphicsLayer {
                lerp(
                    start = 0.7f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                )
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Pronunciation")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.weight(1f))

                if (lessonPage.image != null) {
                    Box(
                        modifier = Modifier
                            .size(96.dp)
                            .clip(CircleShape)
                            .background(
                                Color(android.graphics.Color.parseColor(lessonPage.image)),
                            ),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = lessonPage.word,
                    style = MaterialTheme.typography.headlineLarge,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "الترجمة : " + lessonPage.wordTranslation,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
