package com.example.sharedbooking.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.CurrentUser
import com.example.sharedbooking.DataBase
import com.example.sharedbooking.Items.HomeItem
import com.example.sharedbooking.adapters.HomeAdapter
import com.example.sharedbooking.databinding.FragmentHomeBinding
import com.example.sharedbooking.entities.User

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recycleViewHome
        DataBase.getUsers{ users ->
            val items = mutableListOf<HomeItem>()
            for(item in users){
                items.add(HomeItem(item))
            }
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            recyclerView.adapter = HomeAdapter(items)
        }
    }

}