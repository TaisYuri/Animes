package com.example.uikit.theme.value

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.uikit.R

internal val BaseFontFamily: FontFamily = FontFamily(
    Font(
        resId = R.font.open_sans_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resId = R.font.open_sans_semi_bold,
        weight = FontWeight.SemiBold,
    ),
    Font(
        resId = R.font.open_sans_bold,
        weight = FontWeight.Bold,
    ),
    Font(
        resId = R.font.open_sans_extra_bold,
        weight = FontWeight.ExtraBold,
    ),
    Font(
        resId = R.font.open_sans_italic,
        weight = FontWeight.Thin,
    ),
    Font(
        resId = R.font.open_sans_light,
        weight = FontWeight.Light,
    ),
    Font(
        resId = R.font.open_sans_medium,
        weight = FontWeight.Medium,
    ),

)