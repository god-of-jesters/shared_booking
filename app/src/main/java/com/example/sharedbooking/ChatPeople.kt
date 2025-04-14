package com.example.sharedbooking

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatPeople: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.chat_people)
        val arguments = intent.getStringExtra("item_fio")
        val text = findViewById<TextView>(R.id.textView2)
        text.text = arguments
    }

}