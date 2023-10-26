package com.example.learngermauser.chapters.presentaion.chapters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.learngermauser.chapters.domain.models.Chapter
import com.example.learngermauser.shared.presentaion.common.rightToLeftLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterItem(
    modifier: Modifier = Modifier,
    chapter: Chapter,
    onChapterClick: (Long) -> Unit,
) {
    ElevatedCard(
        onClick = {
            onChapterClick(chapter.id!!)
        },
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = chapter.image),
                contentDescription = "Chapter Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
            )

            Spacer(modifier = Modifier.height(8.dp))
            rightToLeftLayout {
                RtlText(
                    modifier = Modifier.fillMaxWidth(),
                    title = chapter.title,
                    description = chapter.description,
                )
            }
        }
    }
}

@Composable
fun RtlText(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 4.dp),
        )
    }
}
