package com.example.sharedbooking.entities

data class User(
    val name: String = "",
    val age: Int = 0,
    val pol: String = "",
    val city: String = "",
    val cety: String = "",
    val about: String = "",
    val cityApart: String = "",
    val payment: Int = 0,
    val countRooms: Int = 0,
    val transport: Int = 0,
    val countPeople: Int = 0) {
    val defaltUser = User("Пользователь", 0, "Мужской", "Москва", "t.me/, " +
            "vk.com/", "Просто пользователь", "Москва", 0, 0, 0, 0)
}