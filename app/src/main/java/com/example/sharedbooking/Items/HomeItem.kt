package com.example.sharedbooking.Items

import com.example.sharedbooking.R
import com.example.sharedbooking.entities.User

data class HomeItem(
    val imageResId: Int = R.drawable.ic_launcher_foreground,
    var fio: String = "",
    var age: String = "",
    var pol: String = "",
    var city: String = "",
    var payment: Int = 0,
    var countPeople: Int = 0,
    var countRooms: Int = 0,
    var transport: Int = 0,
    var time: String = ""
){
    fun userToHomeItem(user: User): HomeItem {
        return HomeItem(
            fio = user.name,
            age = user.age.toString(),
            pol = user.pol,
            city = user.city,
            payment = user.payment,
            countPeople = user.countPeople,
            countRooms = user.countRooms,
            transport = user.transport,
            time = user.time
        )
    }

}
