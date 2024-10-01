package com.example.animes.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Cards(title: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)

    ) {
        Box(
            modifier = Modifier.border(
                width = 0.5.dp,
                color = Color.Gray.copy(alpha = 0.5f),
                RoundedCornerShape(20.dp)
            )
        ) {
            AsyncImage(
                model = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_light_color_272x92dp.png",
                contentDescription = "Imagem de capa",
                Modifier
                    .height(150.dp)
                    .width(130.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Gray)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(0.dp,8.dp)
        )
    }
}

@Preview
@Composable
private fun CardAnimePreview() {
    Cards("teste")

}