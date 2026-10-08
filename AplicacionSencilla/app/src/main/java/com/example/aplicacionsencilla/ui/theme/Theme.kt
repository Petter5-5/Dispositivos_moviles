package com.example.aplicacionsencilla.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = LightPrimary,

    onPrimary = LightOnPrimary
)

private val DarkColors = darkColorScheme(

    primary = DarkPrimary,

    onPrimary = DarkOnPrimary
)

@Composable
fun AplicacionSencillaComposeTheme(

    darkTheme: Boolean =
        isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme =
            if (darkTheme) {
                DarkColors
            } else {
                LightColors
            },

        content = content
    )
}