package com.example.sharedbooking.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedbooking.Items.HomeItem
import com.example.sharedbooking.R
import com.example.sharedbooking.adapters.HomeAdapter
import com.example.sharedbooking.databinding.FragmentHomeBinding

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

        val items = listOf(
            HomeItem(R.drawable.ic_launcher_foreground, "Гурочкина Кира Романовна", "28.04.2007", "Женский", "Москва", 20000, 2, 2, 10, "до конца жизни",
                heartCheck = false,
                check = false
            ),
            HomeItem(R.drawable.ic_launcher_foreground, "Рыжов Дмитрий Романович", "06.06.2006", "Мужской", "Москва", 20000, 2, 2, 10, "до конца жизни",
            heartCheck = false,
            check = false
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = HomeAdapter(items)
    }
}