package com.example.sharedbooking.Items

data class HomeItem(
    val imageResId: Int,
    val fio: String,
    val birthday: String,
    val pol: String,
    val city: String,
    val payment: Int,
    val countPeople: Int,
    val countRooms: Int,
    val transport: Int,
    val time: String,
    val heartCheck: Boolean,
    val check: Boolean
)
