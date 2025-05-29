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
    var userId: Long = 0L,
    val time: String = ""
){
    fun toMap(): Map<String, Any> {
        return mapOf(
            "name" to this.name,
            "email" to this.email,
            "age" to this.age,
            "pol" to this.pol,
            "city" to this.city,
            "cety" to this.cety,
            "about" to this.about,
            "cityApart" to this.cityApart,
            "payment" to this.payment,
            "countRooms" to this.countRooms,
            "transport" to this.transport,
            "countPeople" to this.countPeople,
            "password" to this.password,
            "time" to this.time,
            "userId" to this.userId
        )
    }
}