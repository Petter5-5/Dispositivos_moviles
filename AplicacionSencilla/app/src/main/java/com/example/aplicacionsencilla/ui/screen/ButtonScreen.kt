package com.example.aplicacionsencilla.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.aplicacionsencilla.R
import com.example.aplicacionsencilla.ui.components.CardCarousel

private const val USER_NAME = "Yeray Trejo Sánchez"

@Composable
fun ButtonScreen() {

    var pressed by remember {
        mutableStateOf(false)
    }

    ButtonScreenContent(
        pressed = pressed,
        onPress = {
            pressed = true
        },
        onReset = {
            pressed = false
        }
    )
}

@Composable
fun ButtonScreenContent(
    pressed: Boolean,
    onPress: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CardCarousel()
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = if (pressed){
                stringResource(R.string.pressed_message, USER_NAME)
            }else {
                stringResource(R.string.pressed_message)
            },
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = onPress,
                enabled = !pressed,
                shape = RoundedCornerShape(18.dp)
            ){
                Text(
                    text = stringResource(R.string.press)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = onReset,
                enabled = pressed,
                shape = RoundedCornerShape(18.dp)
            ){
                Text(
                    text = stringResource(R.string.reset)
                )
            }
        }
    }
}