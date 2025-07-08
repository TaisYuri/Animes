package com.example.uikit.theme

import androidx.compose.ui.unit.Dp
import com.example.uikit.theme.value.MediumSize
import com.example.uikit.theme.value.SmallSize
import com.example.uikit.theme.value.XSmallSize
import com.example.uikit.theme.value.XxSmallSize

data class MoviesSizes(
    val mediumSize: Dp = MediumSize,
    val smallSize: Dp = SmallSize,
    val xSmallSize: Dp = XSmallSize,
    val xxSmallSize: Dp = XxSmallSize,
)
