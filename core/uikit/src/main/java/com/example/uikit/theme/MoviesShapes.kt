package com.example.uikit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class MoviesShapes(
    val xSmallRounded: RoundedCornerShape = RoundedCornerShape(12.dp),
    val smallRounded: RoundedCornerShape = RoundedCornerShape(14.dp),
    val mediumRounded: RoundedCornerShape = RoundedCornerShape(20.dp),
    val largeRounded: RoundedCornerShape = RoundedCornerShape(40.dp),
)
