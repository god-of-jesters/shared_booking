package com.example.sharedbooking.database

import android.util.Log
import com.example.sharedbooking.entities.User
import com.google.firebase.database.FirebaseDatabase

class DBFirebase {
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("users")
    private val chatsRef = database.getReference("chats")

    fun newUser(user: User){
        usersRef.child(user.userId).setValue(user)
        usersRef.push()
    }

    fun getUsers(): MutableList<User>{
        val lis = mutableListOf<User>()
        usersRef.get().addOnSuccessListener { snapshot ->
            for(ref in snapshot.children){
                val user = ref.getValue(User::class.java)
                val id = ref.key?.toLongOrNull()
                Log.d("Firebase", "ID: $id, Name: ${user?.name}")

                if(user != null) {
                    user.userId = id.toString()
                    lis.add(user)
                }
            }
        }
        return lis
    }

    fun newChat(user: User){
        var id = System.currentTimeMillis().toString()
    }
}