package com.phalu.composecrashcourse.data

import kotlinx.serialization.Serializable

@Serializable
data class Nor(
    val common: String? = null,
    val official: String? = null
)
