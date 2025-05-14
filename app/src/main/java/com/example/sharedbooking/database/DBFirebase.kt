package com.example.sharedbooking.database

import android.util.Log
import com.example.sharedbooking.entities.User
import com.google.firebase.database.FirebaseDatabase

class DBFirebase {
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("users")
    private val chatsRef = database.getReference("chats")
    private val newUserRef = usersRef.push()

    fun newUser(user: User){
        newUserRef.setValue(user)
    }


    fun getUsers(): MutableList<User>{
        val lis = mutableListOf<User>()
        usersRef.get().addOnSuccessListener { snapshot ->
            for(ref in snapshot.children){
                val user = ref.getValue(User::class.java)
                val id = ref.key?.toLongOrNull()
                Log.d("Firebase", "ID: $id, Name: ${user?.name}")
                if(user != null) lis.add(user)
            }
        }
        return lis
    }
}