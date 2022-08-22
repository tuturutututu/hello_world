package com.example.hello_world

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hello_world.ui.theme.Hello_worldTheme
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContent {
            Hello_worldTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        val a  = CoroutineScope(Dispatchers.Default).launch {
             delay(5000)
             println("Прошло 5 секунд")
        }

    }


}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        for (i in 1..100){
            item{
                Button(onClick = {
                    Toast.makeText(context, "Вы нажали на кнопку $i", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier.fillMaxWidth(0.5f)){
                    Text(text = "Hello $name!")
                }
                Divider(thickness = 5.dp)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Hello_worldTheme {
        Greeting("Android")
    }
}