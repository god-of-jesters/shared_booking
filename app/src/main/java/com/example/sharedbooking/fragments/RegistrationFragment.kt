package com.example.sharedbooking.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.sharedbooking.databinding.FragmentEditProfileBinding
import com.example.sharedbooking.databinding.RegisterUserBinding

class RegistrationFragment: Fragment() {
    private lateinit var binding: RegisterUserBinding
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = binding.button
        button.setOnClickListener {
            (parentFragment as? RegistrationFragment)?.replaceFragment(ProfileViewFragment())
        }
    }
}