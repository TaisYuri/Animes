package com.example.uikit.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val localColorScheme = staticCompositionLocalOf { MoviesColors() }
private val localSizesScheme = staticCompositionLocalOf { MoviesSizes() }
private val localTypography = staticCompositionLocalOf { MoviesTypography() }
private val localShapesScheme = staticCompositionLocalOf { MoviesShapes() }

private val DarkColorScheme = darkColorScheme(

)

private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,//    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        localColorScheme provides MoviesTheme.color,
        localSizesScheme provides MoviesTheme.sizes,
        localTypography provides MoviesTheme.textStyle,
        localShapesScheme provides MoviesTheme.shapes
    ) {
        val colorScheme = when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

        MaterialTheme(content = content)
    }
}

object MoviesTheme {
    val color: MoviesColors
        @Composable @ReadOnlyComposable get() = localColorScheme.current

    val sizes: MoviesSizes
        @Composable @ReadOnlyComposable get() = localSizesScheme.current

    val textStyle: MoviesTypography
        @Composable @ReadOnlyComposable get() = localTypography.current

    val shapes: MoviesShapes
        @Composable @ReadOnlyComposable get() = localShapesScheme.current
}