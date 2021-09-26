package com.itiudc.breakingbadapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Character(
    val id: Int,
    val name: String,
    val birthday: String,
    val occupation:Array<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: Array<Int>,
    val portrayed: String,
    val category: String
) : Parcelable {
}