package com.example.sharedbooking.entities

data class User(
    var name: String = "",
    val email: String = "",
    var age: Int = 0,
    var pol: String = "",
    var city: String = "",
    var cety: String = "",
    var about: String = "",
    var cityApart: String = "",
    var payment: Int = 0,
    var countRooms: Int = 0,
    var transport: Int = 0,
    var countPeople: Int = 0,
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

    override fun toString(): String {
        return "Имя: ${this.name} \nПочта: ${this.email}"
    }
}