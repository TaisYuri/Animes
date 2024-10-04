package com.example.animes.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animes.domain.model.TopAnimeData
import com.example.animes.presentation.details.Detail

@Composable
fun Cards(
    data: TopAnimeData,
    title: String,
    urlImage: String,
    navigateToDetails: (Detail) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(130.dp)
            .clickable {
                navigateToDetails(
                    Detail(
                        id = "1",
                        title = data.title,
                        description = data.episodes,
                        image = data.images.jpg?.largeImageUrl.orEmpty()
                    )
                )
            }
    ) {
        Box(
            modifier = Modifier.border(
                width = 0.5.dp,
                color = Color.Gray.copy(alpha = 0.5f),
                RoundedCornerShape(20.dp)
            )
        ) {
            AsyncImage(
                model = urlImage,
                contentDescription = "Imagem de capa",
                Modifier
                    .height(150.dp)
                    .width(130.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ),
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Gray)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )
    }
}

