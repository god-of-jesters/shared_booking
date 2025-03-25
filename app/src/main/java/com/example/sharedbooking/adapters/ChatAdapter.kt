package com.example.sharedbooking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.Items.ChatItem
import com.example.sharedbooking.R

class ChatAdapter (private val itemsList: List<ChatItem>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_chat)
        val textViewFi: TextView = itemView.findViewById(R.id.fi_chat)
        val textViewMessage: TextView = itemView.findViewById(R.id.message_chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textViewFi.text = item.fi
        holder.textViewMessage.text = item.message
    }
}