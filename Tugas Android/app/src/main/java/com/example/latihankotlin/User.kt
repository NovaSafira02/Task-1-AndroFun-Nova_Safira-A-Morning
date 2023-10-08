package com.example.latihankotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val email:String,
    val passwod:String
):Parcelable

