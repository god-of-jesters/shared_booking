package com.example.sharedbooking.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.ChatPeople
import com.example.sharedbooking.Items.ChatItem
import com.example.sharedbooking.R
import com.google.gson.Gson

class ChatAdapter (private val items: MutableList<ChatItem>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_chat)
        val textViewFi: TextView = itemView.findViewById(R.id.fi_chat)
        val textViewMessage: TextView = itemView.findViewById(R.id.message_chat)

        init {
            itemView.setOnClickListener {
                val item = items[adapterPosition]
                val intent = Intent(itemView.context, ChatPeople::class.java)
                intent.putExtra("item_fio", item.fi)
                val gson = Gson()
                val json = gson.toJson(items[adapterPosition].messages)
                intent.putExtra("messages", json)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textViewFi.text = item.fi
        holder.textViewMessage.text = item.message
    }
}