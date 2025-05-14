package com.example.sharedbooking.database

import com.example.sharedbooking.entities.User

class db_sql {
    private val firebase: db_firebase = db_firebase()
    var users: List<User> = firebase.getUsers()
}