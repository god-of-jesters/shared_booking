package com.example.sharedbooking.Items

import com.example.sharedbooking.entities.Message

data class ChatItem(
    val userId: Long,
    val fi: String,
    val message: String,
    val messages: List<Message>
)
