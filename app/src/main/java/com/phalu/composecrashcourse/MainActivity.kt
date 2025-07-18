package com.phalu.composecrashcourse

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phalu.composecrashcourse.components.CountryCardWithConstrainLayout
import com.phalu.composecrashcourse.data.CountryInfo
import com.phalu.composecrashcourse.data.getCountryList
import com.phalu.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    private val indiaInfo = CountryInfo(R.drawable.`in`,
        "India",
        "New Delhi",
          "Republic of India",
               "Asia",
            "South Asia",
        "₹",
         "Indian Rupee",
           "+91", ".in")
    private val countries = getCountryList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(countries)
            //Greeting("Demo")
        }
    }
}

@Composable
fun Greeting(name:String){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Hello Phalu $name",
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(Color.LightGray)
                .border(1.dp,Color.Black)
                .clickable { Log.i("onclick","demo click") }
                .padding(10.dp)

        )
    }
}

@Composable
fun MainScreen(countries: List<CountryInfo>) {
    ComposeCrashCourseTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                countries.forEach {
                    CountryCard(countryInfo = it)
                }
            }

        }
    }
}

@Composable
fun CountryCard(countryInfo: CountryInfo){
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

    MainScreen(getCountryList())
}

