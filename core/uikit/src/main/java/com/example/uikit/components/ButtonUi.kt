package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.MoviesTheme

@Composable
fun ButtonUi(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(76.dp)
            .background(
                shape = MoviesTheme.shapes.mediumRounded,
                brush = Brush.sweepGradient(
                    listOf(
                        Color.Green,
                        MoviesTheme.color.orange100
                    )
                )
            ),
        shape = MoviesTheme.shapes.largeRounded,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MoviesTheme.color.orange200
        )
    ) {
        Text(text = "teste", style = MoviesTheme.textStyle.titleLarge    )
    }
}


@Preview
@Composable
private fun PreviewButtonUi() {
    ButtonUi(onClick = {}, modifier = Modifier.fillMaxWidth())
}