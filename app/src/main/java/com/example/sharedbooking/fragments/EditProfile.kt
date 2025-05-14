package com.example.sharedbooking.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.sharedbooking.R
import com.example.sharedbooking.databinding.FragmentEditProfileBinding

class EditProfile : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var button: Button
    private val imageUser = binding.imageChat
    private val fioUser = binding.fio
    private val ageUser = binding.age
    private val polUser = binding.pol
    private val cityUser = binding.city
    private val cetyUser = binding.socCety
    private val aboutU = binding.aboutU
    private val cityApartUser = binding.cityHomeEdit
    private val payment = binding.paymentHomeEdit
    private val countRooms = binding.roomsCountEdit
    private val transportUser = binding.transportEdit
    private val countPeople = binding.peopleCountEdit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = binding.saveProfileButton
        button.setOnClickListener {
            (parentFragment as? ProfileFragment)?.replaceFragment(ProfileViewFragment())
        }
    }

}