package com.phalu.composecrashcourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phalu.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()

        }
    }
}

@Composable
fun MainScreen(){
    val counter = rememberSaveable { mutableStateOf(0) }

    val incrementCounter ={
        counter.value += 1
    }

    val decrementCounter ={
        counter.value -= 1
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(2.dp)
            
        ) {
            Button(onClick = {decrementCounter.invoke() }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Decrement")
            }
            Text(text = "${counter.value}")
            Button(onClick = {incrementCounter.invoke() }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Increment")
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreen()
}

