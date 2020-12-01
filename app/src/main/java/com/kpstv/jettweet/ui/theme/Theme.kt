package com.kpstv.jettweet.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color
import com.kpstv.jettweet.ui.shapes
import com.kpstv.jettweet.ui.typography

private val darkBackground = Color(0xFF15202B)
private val lightBackground = Color(0xFFFFFFFF)
private val twitterBlue = Color(0xFF1DA1F2)

private val DarkColorPalette = darkColors(
    primary = darkBackground,
    onPrimary = Color.White,
    primaryVariant = darkBackground,
    surface = darkBackground,
    onSurface = Color.White,
    onSecondary = Color.White,
    background = darkBackground,
    secondary = twitterBlue,
)

private val LightColorPalette = lightColors(
    primary = lightBackground,
    primaryVariant = lightBackground,
    onPrimary = Color.Black,
    surface = lightBackground,
    onSurface = Color.Black,
    onSecondary = Color.Black,
    background = lightBackground,
    secondary = twitterBlue,
)

@Composable
fun JetTweetTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = JetTweetTypography,
        shapes = shapes,
        content = content
    )
}