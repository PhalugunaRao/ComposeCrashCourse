package com.phalu.composecrashcourse.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.phalu.composecrashcourse.components.CountryCard
import com.phalu.composecrashcourse.data.Country
import com.phalu.composecrashcourse.data.getCountryListFromJson
import com.phalu.composecrashcourse.ui.theme.ComposeCrashCourseTheme

@Composable
fun MainScreen(countryList : MutableList<Country>,innerPaddingValues: PaddingValues) {

    ComposeCrashCourseTheme {
        Surface(modifier = Modifier.fillMaxSize().padding(paddingValues = innerPaddingValues)) {
            LazyColumn {
                items(countryList) {
                    CountryCard(countryInfo = it)
                }
            }
        }
    }
}