package com.example.sharedbooking.fragments

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.CurrentUser
import com.example.sharedbooking.DataBase
import com.example.sharedbooking.Items.ChatItem
import com.example.sharedbooking.Items.HomeItem
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

        DataBase.getMyChats{chats ->
            val items = mutableListOf<ChatItem>()
            var loadedCount = 0

            for (item in chats) {
                val opponentId = if (item.userId1 == CurrentUser.user!!.userId) item.userId2 else item.userId1

                DataBase.findName(opponentId) { name ->
                    items.add(
                        ChatItem(
                            userId = opponentId,
                            fi = name,
                            message = item.messages.last().text,
                            messages = item.messages
                        )
                    )

                    loadedCount++
                    if (loadedCount == chats.size) {
                        recyclerView.layoutManager = LinearLayoutManager(view.context)
                        recyclerView.adapter = ChatAdapter(items)
                    }
                }
            }
        }
    }

}