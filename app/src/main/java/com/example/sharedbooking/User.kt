package com.example.sharedbooking

class User(name: String, birthday: String, pol: String, city: String, cety: String,
           about: String, cityApart: String, payment: Int, count: Int, transport: Int,
           count_people: Int) {
    private var name: String = name ?: "имя"
    private var birthday: String = birthday ?: "01.01.1970"
    private var pol: String = pol ?: "Мужской"
    private var city: String = city ?: "Москва"
    private var cozCety: String = cety ?: "teg/"
    private var about: String = about ?: "Ну что-то про себя"
    private var city_apart: String = city ?: "Москва"
    private var payment: Int = payment ?: 0
    private var count: Int = count ?: 0
    private var transport: Int = transport ?: 0
    private var count_people: Int = count_people ?: 0
}