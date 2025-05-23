package com.example.sharedbooking.entities

data class User(
    val name: String = "",
    val email: String = "",
    val age: Int = 0,
    val pol: String = "",
    val city: String = "",
    val cety: String = "",
    val about: String = "",
    val cityApart: String = "",
    val payment: Int = 0,
    val countRooms: Int = 0,
    val transport: Int = 0,
    val countPeople: Int = 0,
    val password: String = "",
    var userId: String = "",
    val time: String = ""
)