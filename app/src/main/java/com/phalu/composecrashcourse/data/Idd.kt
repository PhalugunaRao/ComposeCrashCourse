package com.phalu.composecrashcourse.data

import kotlinx.serialization.Serializable

@Serializable
data class Idd(
    val root: String? = null,
    val suffixes: List<String>? = null
)
