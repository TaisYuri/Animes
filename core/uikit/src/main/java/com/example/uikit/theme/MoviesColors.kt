package com.example.uikit.theme

import androidx.compose.ui.graphics.Color
import com.example.uikit.theme.value.Black300
import com.example.uikit.theme.value.BlackBackground
import com.example.uikit.theme.value.GrayScale100
import com.example.uikit.theme.value.GrayScale200
import com.example.uikit.theme.value.GrayScale250
import com.example.uikit.theme.value.GrayScale300
import com.example.uikit.theme.value.GrayScaleBase
import com.example.uikit.theme.value.BlackBaseDarkAlternative
import com.example.uikit.theme.value.GrayScaleSubtitle
import com.example.uikit.theme.value.GrayScaleSubtitleDark
import com.example.uikit.theme.value.Orange100
import com.example.uikit.theme.value.Orange200
import com.example.uikit.theme.value.WhiteBackground
import com.example.uikit.theme.value.WhiteBase

data class MoviesColors(
    val grayScale100: Color = GrayScale100,
    val grayScale200: Color = GrayScale200,
    val grayScale250: Color = GrayScale250,
    val grayScale300: Color = GrayScale300,
    val grayScaleBase: Color = GrayScaleBase,
    val grayScaleSubtitle: Color = GrayScaleSubtitle,
    val grayScaleSubtitleDark: Color = GrayScaleSubtitleDark,
    val blackBackground: Color = BlackBackground,
    val blackBaseDarkAlternative: Color = BlackBaseDarkAlternative,
    val black300: Color = Black300,
    val whiteBackground: Color = WhiteBackground,
    val whiteBase: Color = WhiteBase,
    val orange100: Color = Orange100,
    val orange200: Color = Orange200
)
