package com.example.aplicacionsencilla.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacionsencilla.ui.theme.AplicacionSencillaComposeTheme

@Preview(
    name = "Modo claro",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewLight(){
    AplicacionSencillaComposeTheme(
        darkTheme = false
    ) {

        Surface(modifier = Modifier.fillMaxSize()
        ) {

            ButtonScreenContent(
                pressed = true,
                onPress = {},
                onReset = {}
            )
        }
    }
}

@Preview(
    name = "Modo oscuro",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewDark() {

    AplicacionSencillaComposeTheme(
        darkTheme = true
    ) {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            ButtonScreenContent(
                pressed = true,
                onPress = {},
                onReset = {}
            )
        }
    }
}

