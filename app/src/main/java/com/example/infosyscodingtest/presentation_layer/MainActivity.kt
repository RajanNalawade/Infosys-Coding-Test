package com.example.infosyscodingtest.presentation_layer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.infosyscodingtest.presentation_layer.components.CitiList
import com.example.infosyscodingtest.presentation_layer.components.MainTitle
import com.example.infosyscodingtest.ui.theme.InfosysCodingTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfosysCodingTestTheme(darkTheme = viewModel.selected1.value) {

                val data = viewModel.listAuCities.value
                val loading = viewModel.loading.value

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (loading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(64.dp)
                                .wrapContentSize(Alignment.Center),
                            color = MaterialTheme.colorScheme.primary,
                        )
                    } else {
                        Column {
                            MainTitle(
                                name = "State of Australia",
                                change = viewModel.selected1.value,
                                onCheckedChange = {
                                    viewModel.selected1.value = it
                                })
                            CitiList(listCities = viewModel.listAuCities.value)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InfosysCodingTestTheme {
        Greeting("Android")
    }
}