package com.littlelemon.weatherappk.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val AppColorTheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)


@Composable
fun WeatherAppKTheme(

    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = AppColorTheme,
        typography = Typography,
        content = content
    )
}