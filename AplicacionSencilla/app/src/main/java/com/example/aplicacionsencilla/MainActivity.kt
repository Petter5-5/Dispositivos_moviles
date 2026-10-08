package com.example.aplicacionsencilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aplicacionsencilla.ui.screen.ButtonScreen
import com.example.aplicacionsencilla.ui.theme.AplicacionSencillaComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AplicacionSencillaComposeTheme {
                ButtonScreen()
            }
        }
    }
}
