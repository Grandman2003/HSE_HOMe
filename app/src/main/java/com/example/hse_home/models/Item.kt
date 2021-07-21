package com.example.hse_home.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface Item: Parcelable{
    @Parcelize
    data class Skills(val skills: Array<Skill>): Item
    @Parcelize
    data class ProfileItem(val profile: Profile): Item
    @Parcelize
    data class ProjectInfo(val info: String):Item
    @Parcelize
    data class Header(val header: String):Item

}