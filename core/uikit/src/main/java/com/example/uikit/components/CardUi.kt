package com.example.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.uikit.theme.MoviesTheme

@Composable
fun CardUi(
    urlImage: String,
    navigateToDetails: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(220.dp)
            .clickable {
                navigateToDetails()
            },
        shape = MoviesTheme.shapes.smallRounded,
        colors = CardColors(
            containerColor = MoviesTheme.color.grayScale300.copy(alpha = 0.5f),
            contentColor = Color.Transparent,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        border = BorderStroke(
            width = 0.5.dp,
            color = MoviesTheme.color.grayScale300.copy(alpha = 0.5f),
        )
    ) {
        AsyncImage(
            model = urlImage,
            contentDescription = "Imagem de capa",
            Modifier
                .height(220.dp)
                .width(150.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                ),
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(MoviesTheme.color.grayScale300)
        )

    }
}

@Preview
@Composable
private fun PreviewCardUi() {
    CardUi(
        urlImage = "https://upload.wikimedia.org/wikipedia/commons/7/70/Example.png?20120323050937",
        navigateToDetails = {}
    )
}