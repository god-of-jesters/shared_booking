package com.example.sharedbooking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
    private lateinit var send: Button
    private lateinit var messageEdit: EditText
    lateinit var adapter: MessageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.chat_people)
        val arguments = intent.getStringExtra("item_fio")
        val id = intent.getLongExtra("id", 0)
        val json = intent.getStringExtra("messages")
        if (json == null) {
            Log.e("ChatPeople", "messages JSON is null!")
            finish() // или покажи ошибку
            return
        }
        val type = object : TypeToken<MutableList<Message>>() {}.type
        val messages: MutableList<Message> = Gson().fromJson(json, type)
        val recycler = findViewById<RecyclerView>(R.id.messages)
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = MessageAdapter(messages)
        recycler.adapter = adapter
        val text = findViewById<TextView>(R.id.textView2)
        send = findViewById(R.id.message_send)
        var m = ""
        messageEdit = findViewById(R.id.messageEdit)
        send.setOnClickListener {
            m = messageEdit.text.toString().trim()
            if(m.isNotEmpty()){
                DataBase.addNewMessage(id!!.toLong(), m)
                messages.add(Message(id!!.toLong(), m))
                adapter.notifyItemInserted(messages.size - 1)
                recycler.scrollToPosition(messages.size - 1)
                messageEdit.text.clear()
            }
        }
        text.text = arguments
        back = findViewById(R.id.chat_back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("openFragment", "chats")
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}