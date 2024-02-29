package com.example.subsmissionsdicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable
