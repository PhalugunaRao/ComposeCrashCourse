package com.phalu.composecrashcourse

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.phalu.composecrashcourse.components.CountryInfoAppScaffold
import com.phalu.composecrashcourse.data.Country
import com.phalu.composecrashcourse.data.getCountryListFromJson
import com.phalu.composecrashcourse.screens.MainScreen

class MainActivity : ComponentActivity() {
    private lateinit var countryList: MutableList<Country>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryList = getCountryListFromJson(this.applicationContext)
        setContent {
            CountryInfoAppScaffold(countryList)
        }
    }
}



