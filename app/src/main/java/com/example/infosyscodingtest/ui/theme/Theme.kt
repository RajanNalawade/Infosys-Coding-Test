package com.example.infosyscodingtest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Black1,
    //primaryVariant = Color.White,
    onPrimary = white,
    secondary = Black1,
    onSecondary = white,
    error = RedErrorLight,
    background = Black2,
    onBackground = white,
    surface = Black1,
    onSurface = white,
)

private val LightColorScheme = lightColorScheme(
    primary = Grey2,
    //primaryVariant = Blue400,
    onPrimary = Black2,
    secondary = white,
    //secondaryVariant = Teal300,
    onSecondary = Black1,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Black1,
    surface = white,
    onSurface = Black2,

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
fun InfosysCodingTestTheme(
    darkTheme: Boolean = true,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}

/*@Composable
fun AppTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
){
    MaterialTheme(colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme){
        content()
    }
}*/
