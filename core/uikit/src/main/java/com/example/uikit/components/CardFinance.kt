package com.example.uikit.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.MoviesTheme

@Composable
fun CardFinance(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = MoviesTheme.shapes.mediumRounded,
        colors = CardColors(
            containerColor = MoviesTheme.color.grayScale300,
            contentColor = MoviesTheme.color.whiteBackground,
            disabledContainerColor = MoviesTheme.color.grayScale300,
            disabledContentColor = MoviesTheme.color.black300
        )
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.weight(1F),
                text = "Texto 1"
            )
            Text(
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.End,
                text = "Texto 2"
            )
        }


    }
}

@Composable
@Preview
fun ViewCardFinance() {
    CardFinance(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), onClick = {})
}