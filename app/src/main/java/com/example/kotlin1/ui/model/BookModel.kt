package com.example.kotlin1.ui.model

import java.io.Serializable

data class BookModel(
    val title: String,
    val description: String,
    val image: Int
) : Serializable