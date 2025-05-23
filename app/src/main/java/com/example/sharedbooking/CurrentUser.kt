package com.example.sharedbooking

import com.example.sharedbooking.entities.User

object CurrentUser {
    var name: String = ""
    var email: String = ""
    var age: Int = 0
    var pol: String = ""
    var city: String = ""
    var cety: String = ""
    var about: String = ""
    var cityApart: String = ""
    var payment: Int = 0
    var countRooms: Int = 0
    var transport: Int = 0
    var countPeople: Int = 0
    var userId: String = ""

    fun create(user: User){
        name = user.name
        email = user.email
        age = user.age
        pol = user.pol
        city = user.city
        cety = user.cety
        about = user.about
        cityApart = user.cityApart
        payment = user.payment
        countRooms = user.countRooms
        transport = user.transport
        countPeople = user.countPeople
        userId = user.userId
    }
}