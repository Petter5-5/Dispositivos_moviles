package com.example.aplicacionsencilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicacionsencilla.ui.theme.ActividadBotonComposeTheme

private const val USER_NAME = "Yeray Trejo Sánchez"


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ActividadBotonComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ButtonActivity()
                }
            }
        }
    }
}

@Composable
fun ButtonActivity() {

    var pressed by remember {
        mutableStateOf(false)
    }

    ButtonActivityContent(
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
fun ButtonActivityContent(
    pressed: Boolean,
    onPress: () -> Unit,
    onReset: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 24.dp,
                vertical = 20.dp
            ),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        CardCarousel()

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Text(
            text = if (pressed) {
                stringResource(
                    R.string.pressed_message,
                    USER_NAME
                )
            } else {
                stringResource(
                    R.string.initial_message
                )
            },

            style = MaterialTheme.typography.titleMedium,

            fontWeight = FontWeight.Medium,

            textAlign = TextAlign.Center,

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,

            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = onPress,

                enabled = !pressed,

                shape = RoundedCornerShape(18.dp),

                contentPadding = ButtonDefaults.ContentPadding
            ) {

                Text(
                    text = stringResource(
                        R.string.press
                    )
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Button(
                onClick = onReset,

                enabled = pressed,

                shape = RoundedCornerShape(18.dp)
            ) {

                Text(
                    text = stringResource(
                        R.string.reset
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardCarousel() {

    val pagerState = rememberPagerState(
        pageCount = {
            5
        }
    )

    HorizontalPager(
        state = pagerState,

        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),

        contentPadding = PaddingValues(
            horizontal = 32.dp
        ),

        pageSpacing = 12.dp
    ) { page ->

        Card(
            modifier = Modifier.fillMaxSize(),

            shape = RoundedCornerShape(24.dp),

            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.primaryContainer
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = stringResource(
                        R.string.card_label,
                        page + 1
                    ),

                    style =
                        MaterialTheme.typography.headlineSmall,

                    fontWeight = FontWeight.Bold,

                    color =
                        MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview(
    name = "Modo claro",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewLight() {

    ActividadBotonComposeTheme(
        darkTheme = false
    ) {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            ButtonActivityContent(
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

    ActividadBotonComposeTheme(
        darkTheme = true
    ) {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            ButtonActivityContent(
                pressed = true,
                onPress = {},
                onReset = {}
            )
        }
    }
}