package com.phalu.composecrashcourse.data

import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
    val latlng: List<Double>? = null
)
