package com.phalu.composecrashcourse

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var counter = MutableLiveData<Int>(0)

    val incrementCounter ={
       counter.value = counter.value?.plus(1)
    }

    val decrementCounter ={
       counter.value =  counter.value?.minus(1)
    }

}