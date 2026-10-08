package com.example.prueba

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(stringResource(R.string.app_name))
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            // Acción del botón flotante
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            ) { paddingValues ->

                Counter(
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = stringResource(R.string.contador) + " $count"
        )

        Button(
            onClick = {
                count++
            }
        ) {
            Text(stringResource(R.string.Incremento))
        }

        Button(
            onClick = {
                count--
            }
        ) {
            Text(stringResource(R.string.decremento))
        }

        MyButton(
            onClick = {
                count = 0
            }
        )
    }
}

@Composable
fun MyButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small
    ) {
        Text(stringResource(R.string.Inicializar))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Scaffold Example")
                }
            )
        }
    ) { paddingValues ->

        Text(
            text = "This is the content",
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(
    name = "Vista previa principal",
    showBackground = true,
    backgroundColor = 0xFF00FF00
)
@Preview(
    name = "Vista 2",
    locale = "es"
)
@Composable
fun MyComposablePreview() {
    Counter()
}
