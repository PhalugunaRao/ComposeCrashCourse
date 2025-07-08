package com.phalu.composecrashcourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Button(onClick = { Log.i("MainScreen","Some one Clicken me")}) {
        Text(text = "Click me 1")
    }
    Button(onClick = { Log.i("MainScreen","Some one Clicken me")}) {
        Text(text = "Click me 2")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreen()
}

