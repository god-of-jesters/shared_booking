package com.example.sharedbooking.entities

data class Chat(
    val userId1: Long = 0,
    val userId2: Long = 0,
    val messages: List<Message> = mutableListOf()
)