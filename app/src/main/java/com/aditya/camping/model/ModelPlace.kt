package com.aditya.camping.model

import java.io.Serializable

data class ModelPlace(
    var name: String = "",
    var description: String = "",
    var isFavorited: Boolean = false,
    var photo: Int = 0
): Serializable