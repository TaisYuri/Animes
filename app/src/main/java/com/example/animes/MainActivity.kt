package com.example.animes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animes.domain.model.TopAnimeData
import com.example.animes.presentation.TopAnimeViewModel
import com.example.animes.presentation.components.ButtonGradient
import com.example.animes.presentation.components.SnackBarComponent
import com.example.animes.ui.theme.AnimeSTheme
import com.example.animes.ui.theme.lightBlue
import com.example.animes.ui.theme.lightRed
import com.example.animes.ui.theme.purple
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    ViewModelInject()
                    PrimeiraTela()
                }
            }
        }
    }
}

@Composable
fun ViewModelInject(viewModel: TopAnimeViewModel = koinViewModel()) {
//        viewModel.topAnimes.value?.data?.get(0)?.let {
//            Greeting(title)
//        }
    val teste by viewModel.uiState.collectAsState()
    teste.topAnimes?.data?.let { ListTest(it) }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ListTest(name: List<TopAnimeData>) {

    Column(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
        name.forEach {
            Text(text = it.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimeSTheme {
        ViewModelInject()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeiraTela() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "TopAppBar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray),
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello!")
            Text(text = "Hello2!")
            ButtonGradient(
                onClick = {},
                text = "Cadastrar",
                colors = listOf(lightBlue, purple, lightRed)
            )
            SnackBarComponent()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(text = "row1")
                Text(text = "row2")

            }
        }
    }
}