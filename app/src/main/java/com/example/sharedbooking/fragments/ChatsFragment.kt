package com.example.sharedbooking.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.Items.ChatItem
import com.example.sharedbooking.R
import com.example.sharedbooking.adapters.ChatAdapter
import com.example.sharedbooking.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {
    private lateinit var binding: FragmentChatsBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recycleViewChats

        val items = listOf(
            ChatItem(R.drawable.ic_launcher_foreground, "Фамилия Имя1", "Сообщение"),
            ChatItem(R.drawable.ic_launcher_foreground, "Фамилия Имя2", "Сообщение"),
            ChatItem(R.drawable.ic_launcher_foreground, "Фамилия Имя3", "Сообщение"),
            ChatItem(R.drawable.ic_launcher_foreground, "Фамилия Имя4", "Сообщение")
        )

        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ChatAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}