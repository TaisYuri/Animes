package com.example.uikit.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.value.BaseFontFamily
import com.example.uikit.theme.value.BaseFontSize
import com.example.uikit.theme.value.LargeFontSize

data class MoviesTypography(
    val titleLarge: TextStyle = TextStyle(
        fontFamily = BaseFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = LargeFontSize,
        lineHeight = 18.sp,
        letterSpacing = LargeFontSize.times(-0.02)  //corresponde a -2%
    ),
    val base: TextStyle = TextStyle(
        fontFamily = BaseFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = BaseFontSize,
        letterSpacing = LargeFontSize.times(-0.02)
    )
)
