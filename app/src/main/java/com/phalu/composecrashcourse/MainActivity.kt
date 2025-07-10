package com.phalu.composecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.phalu.composecrashcourse.components.CountryCard
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
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            CountryCard(countryInfo)
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

