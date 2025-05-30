package com.example.sharedbooking.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.sharedbooking.CurrentUser
import com.example.sharedbooking.DataBase
import com.example.sharedbooking.R
import com.example.sharedbooking.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var button: Button
    private lateinit var imageUser: EditText
    private lateinit var fioUser: EditText
    private lateinit var ageUser: EditText
    private lateinit var polUser: EditText
    private lateinit var cityUser: EditText
    private lateinit var cetyUser: EditText
    private lateinit var aboutU: EditText
    private lateinit var cityApartUser: EditText
    private lateinit var payment: EditText
    private lateinit var countRooms: EditText
    private lateinit var transportUser: EditText
    private lateinit var countPeople: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        button = binding.buttonProfile
        fioUser = binding.fio
        ageUser = binding.age
        polUser = binding.pol
        cityUser = binding.city
        cetyUser = binding.socCety
        aboutU = binding.aboutU
        cityApartUser = binding.cityHomeEdit
        payment = binding.paymentHomeEdit
        countRooms = binding.roomsCountEdit
        transportUser = binding.transportEdit
        countPeople = binding.peopleCountEdit

        fioUser.setText(CurrentUser.user!!.name.toString())
        ageUser.setText(CurrentUser.user!!.age.toString())
        polUser.setText(CurrentUser.user!!.pol.toString())
        cityUser.setText(CurrentUser.user!!.city.toString())
        cetyUser.setText(CurrentUser.user!!.cety.toString())
        aboutU.setText(CurrentUser.user!!.about.toString())
        cityApartUser.setText(CurrentUser.user!!.cityApart.toString())
        payment.setText(CurrentUser.user!!.payment.toString())
        countRooms.setText(CurrentUser.user!!.countRooms.toString())
        transportUser.setText(CurrentUser.user!!.transport.toString())
        countPeople.setText(CurrentUser.user!!.countPeople.toString())

        button.setOnClickListener {
            val user = CurrentUser.user ?: return@setOnClickListener

            user.name = fioUser.text.toString()
            user.age = ageUser.text.toString().toIntOrNull() ?: 0
            user.pol = polUser.text.toString()
            user.city = cityUser.text.toString()
            user.cety = cetyUser.text.toString()
            user.about = aboutU.text.toString()
            user.cityApart = cityApartUser.text.toString()
            user.payment = payment.text.toString().toIntOrNull() ?: 0
            user.countRooms = countRooms.text.toString().toIntOrNull() ?: 0
            user.transport = transportUser.text.toString().toIntOrNull() ?: 0
            user.countPeople = countPeople.text.toString().toIntOrNull() ?: 0

            DataBase.updateUser(user)
        }
        return binding.root
    }
}