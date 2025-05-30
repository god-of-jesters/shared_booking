package com.example.sharedbooking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.adapters.MessageAdapter
import com.example.sharedbooking.entities.Message
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ChatPeople: AppCompatActivity() {
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.chat_people)
        val arguments = intent.getStringExtra("item_fio")
        val json = intent.getStringExtra("messages").toString()
        val map = object : TypeToken<List<Message>>() {}.type
        val messages: List<Message> = Gson().fromJson(json, map)
        val recycler = findViewById<RecyclerView>(R.id.messages)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MessageAdapter(messages)
        val text = findViewById<TextView>(R.id.textView2)

        text.text = arguments
        back = findViewById(R.id.chat_back)
        back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("openFragment", "chats")
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }
}