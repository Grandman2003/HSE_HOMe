package com.example.hse_home.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Profile(val firstname:String,val lastname:String, val info:String) : Parcelable {
}