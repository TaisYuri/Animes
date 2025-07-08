package com.example.uikit.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.MoviesTheme

@Composable
fun ButtonAnimationUi(modifier: Modifier = Modifier, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }
    val animatedSize = animateDpAsState(
        targetValue = if (isClicked) 70.dp else 300.dp
    )
    Button(
        onClick = {
            onClick()
            isClicked = !isClicked
        },
        modifier = modifier

            .width(animatedSize.value)
            .background(
                shape = MoviesTheme.shapes.mediumRounded,
                brush = Brush.sweepGradient(
                    listOf(
                        Color.Black,
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
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(50.dp)
        ){
            FadeAnimatedVisibility(visible = isClicked) {
                CircularProgressIndicator(
                    modifier = Modifier.width(60.dp),
                    color = MoviesTheme.color.black300,
                    strokeWidth = 2.dp
                )
            }
            FadeAnimatedVisibility(visible = isClicked.not()) {
                Text(text = "teste", style = MoviesTheme.textStyle.titleLarge)

            }
        }

    }
}

@Composable
fun FadeAnimatedVisibility(
    visible:Boolean,
    content: @Composable() AnimatedVisibilityScope.()-> Unit
){
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
        content = content
    )
}


@Preview
@Composable
private fun PreviewButtonUi() {
    ButtonAnimationUi(onClick = {})
}