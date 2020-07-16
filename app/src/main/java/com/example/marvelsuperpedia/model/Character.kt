package com.example.marvelsuperpedia.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail
) : Parcelable
