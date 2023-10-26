package com.example.learngermauser.lessons.presentaion.lessons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learngermauser.lessons.domain.models.Lesson
import com.example.learngermauser.shared.presentaion.common.rightToLeftLayout

@Composable
fun LessonItem(
    modifier: Modifier = Modifier,
    lesson: Lesson,
    lessonNumber: Int,
    onItemClick: (Long) -> Unit,
) {
    Surface(
        modifier = modifier
            .height(200.dp)
            .clickable {
                onItemClick(lesson.id!!)
            }
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 6.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "$lessonNumber", style = MaterialTheme.typography.displayLarge)

            Spacer(modifier = Modifier.height(16.dp))

            rightToLeftLayout {
                Text(text = lesson.title, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
