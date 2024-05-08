package pe.edu.upc.mark02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.mark02.repositories.JokeRepository
import pe.edu.upc.mark02.ui.theme.Mark02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mark02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(){

    val jokeRepository=JokeRepository()

    val joke=remember{
        mutableStateOf("")

    }

    Scaffold {paddingValues->
        Column(modifier=Modifier
                .padding(paddingValues)
                .fillMaxSize(),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = joke.value)
            Button(onClick = {
                jokeRepository.getRandomJoke (callback={
                    System.out.println(it.text)
                    joke.value=it.text
                })
            }) {
                Text(text = "Get random joke")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mark02Theme {
        Home()
    }
}