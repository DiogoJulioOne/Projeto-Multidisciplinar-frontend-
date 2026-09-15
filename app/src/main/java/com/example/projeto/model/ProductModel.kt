package com.example.projeto.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val location: String,
    val description: String?,
    val state: String,
    val quantity: Int,
    val category: String,
    val authorId: String,
    val photos: List<Photo>
) : Parcelable

@Parcelize
data class Photo(
    val id: String,
    val url: String
) : Parcelable