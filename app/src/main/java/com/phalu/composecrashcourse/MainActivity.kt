package com.phalu.composecrashcourse

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContentInfo
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phalu.composecrashcourse.components.CountryCardWithConstrainLayout
import com.phalu.composecrashcourse.data.Country
import com.phalu.composecrashcourse.data.CountryInfo
import com.phalu.composecrashcourse.data.getCountryList
import com.phalu.composecrashcourse.data.getCountryListFromJson
import com.phalu.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            //Greeting("Demo")
        }
    }
}



@Composable
fun MainScreen() {
    val context: Context = LocalContext.current
    val countries = getCountryListFromJson(context)
    ComposeCrashCourseTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(countries){
                    CountryCard(countryInfo = it)
                }
            }
        }
    }
}

@Composable
fun CountryCard(countryInfo: Country){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .border(1.dp,Color.LightGray).wrapContentHeight(align = Alignment.Top),
        shadowElevation = 2.dp){
        CountryCardWithConstrainLayout(countryInfo)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    MainScreen()
}

