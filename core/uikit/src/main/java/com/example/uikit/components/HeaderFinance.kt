package com.example.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.MoviesTheme

@Composable
fun HeaderFinance(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current  // tamanho da tela
    val radius = configuration.screenWidthDp.dp.times(3)

    val color = MoviesTheme.color.blackBackground

    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .offset(x = 0.dp, y = radius.times(-1))
                .align(Alignment.BottomCenter),
            onDraw = {
                drawCircle(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Green, Color.Green),//estudar pq nao esta aplicando gradiente
                        startY = radius.div(2).toPx(),
                        endY = radius.toPx()
                    ),
                    radius = radius.toPx(),
                    colorFilter = ColorFilter.tint(color)
                )
            })
        Image(
            painter = painterResource(R.drawable.ic_header_backgroud),
            contentDescription = null
        )
    }
}


@Composable
@Preview
fun PreviewHeaderFinance() {
    HeaderFinance(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp))
}