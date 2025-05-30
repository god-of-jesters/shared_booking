package com.example.sharedbooking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.CurrentUser
import com.example.sharedbooking.R
import com.example.sharedbooking.entities.Message

class MessageAdapter(private val items: MutableList<Message>): RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    private lateinit var i: MutableList<Message>
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val message: TextView = itemView.findViewById(R.id.message_self)
        val message_a: TextView = itemView.findViewById(R.id.message_a)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.measage, parent, false)
        i = items
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return i.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = i[position]
        if (item.userId == CurrentUser.user!!.userId){
            holder.message.text = item.text
            holder.message_a.text = ""
            holder.message_a.visibility = TextView.INVISIBLE
        }else{
            holder.message.text = ""
            holder.message_a.text = item.text
            holder.message.visibility = TextView.INVISIBLE
        }
    }
}