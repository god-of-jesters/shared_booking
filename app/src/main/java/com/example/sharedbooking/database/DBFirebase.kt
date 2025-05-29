package com.example.sharedbooking.database

import android.util.Log
import com.example.sharedbooking.entities.User
import com.google.firebase.database.FirebaseDatabase

class DBFirebase {
    private val database = FirebaseDatabase.getInstance()
    private val chatsRef = database.getReference("chats")
    private val usersRef = database.getReference("users")


    fun newUser(user: User){
        usersRef.child(user.userId.toString()).setValue(user.toMap())
    }

    fun getUsers(callback: (List<User>) -> Unit){
        usersRef.get().addOnSuccessListener { snapshot ->
            val list = mutableListOf<User>()
            for (ref in snapshot.children) {
                val user = ref.getValue(User::class.java)
                val id = ref.key?.toLongOrNull()
                if (user != null) {
                    user.userId = id!!
                    list.add(user)
                }
            }
            callback(list)
        }
    }

    fun newChat(){
        var id = System.currentTimeMillis().toString()
        chatsRef.child(id).setValue("Тадаааам")
    }

    fun checkUserIn(emal: String, password: String): Boolean{
        var f = false
        usersRef.get().addOnSuccessListener { snapshot ->
            for (ref in snapshot.children) {
                val user = ref.getValue(User::class.java)
                val id = ref.key?.toLongOrNull()
                if (user != null) {
                    user.userId = id!!
                    if(user.email == emal && password == user.password){
                        f = true
                        break
                    }
                }
            }
        }
        return f
    }
}