package com.phalu.composecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phalu.composecrashcourse.components.CountryCard
import com.phalu.composecrashcourse.components.CountryCardWithConstrainLayout
import com.phalu.composecrashcourse.data.CountryInfo
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(indiaInfo)
        }
    }
}

@Composable
fun MainScreen(countryInfo: CountryInfo) {
    ComposeCrashCourseTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(1.0f)
                .padding(5.dp,50.dp,5.dp,5.dp)
                .border(1.dp, Color.LightGray)
                .wrapContentHeight(align = Alignment.Top),
            shadowElevation = 2.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            CountryCardWithConstrainLayout(countryInfo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
     val indiaInfo = CountryInfo(R.drawable.`in`,
        "India",
        "New Delhi",
        "Republic of India",
        "Asia",
        "South Asia",
        "₹",
        "Indian Rupee",
        "+91", ".in")
    MainScreen(indiaInfo)
}

