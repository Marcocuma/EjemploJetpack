package com.example.jetpack.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Persona(val nombre:String, val apellidos:String) : Parcelable {
}