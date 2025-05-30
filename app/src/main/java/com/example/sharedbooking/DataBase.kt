package com.example.sharedbooking

import android.util.Log
import com.example.sharedbooking.entities.Chat
import com.example.sharedbooking.entities.Message
import com.example.sharedbooking.entities.User
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue

object DataBase {
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
            return@addOnSuccessListener
        }.addOnFailureListener {
            callback(mutableListOf<User>())
        }
    }

    fun findName(userId: Long, callback: (String) -> Unit){
        getUsers { u ->
            for(i in u){
                if(i.userId == userId){
                    callback(i.name)
                    return@getUsers
                }
            }
        }
    }

    fun getMyChats(callback: (List<Chat>) -> Unit) {
        chatsRef.get().addOnSuccessListener { snapshot ->
            val chats = mutableListOf<Chat>()
            for (ref in snapshot.children) {
                val chatss = ref.getValue(SuppotClass::class.java)
                println(chatss!!.userId2)
                var list = mutableListOf<Message>()
                for(i in chatss!!.messages.keys){
                    list.add(Message(i.toLong(), chatss!!.messages.get(i).toString()))
                }
                val chat = Chat(chatss!!.userId1, chatss!!.userId2, list)
                if (chat!!.userId1 == CurrentUser.user!!.userId || chat.userId2 == CurrentUser.user!!.userId){
                    chats.add(chat)
                }
            }
            callback(chats)
            return@addOnSuccessListener
        }
    }

    fun newChat(id: Long){
        val idChat = System.currentTimeMillis().toString()
        val chatData = mapOf(
            "userId1" to CurrentUser.user!!.userId,
            "userId2" to id,
            "messages" to mapOf(
                idChat to "Привет")
        )
        chatsRef.child(idChat).setValue(chatData)
    }

    fun checkUserIn(email: String, password: String, callback: (User?) -> Unit) {
        usersRef.get().addOnSuccessListener { snapshot ->
            for (ref in snapshot.children) {
                val user = ref.getValue(User::class.java)
                val id = ref.key?.toLongOrNull()
                if (user != null) {
                    user.userId = id!!
                    if (user.email == email && password == user.password) {
                        callback(user)
                        return@addOnSuccessListener
                    }
                }
            }
            callback(null)
        }.addOnFailureListener {
            callback(null)
        }
    }

    fun updateUser(user: User) {
        usersRef.child(user.userId.toString()).setValue(user)
    }


}

class SuppotClass (val userId1: Long = 0,
                   val userId2: Long = 0,
                   val messages: Map<String, String> = emptyMap())

