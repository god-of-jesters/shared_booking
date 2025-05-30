package com.example.sharedbooking.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sharedbooking.CurrentUser
import com.example.sharedbooking.DataBase
import com.example.sharedbooking.MainActivity
import com.example.sharedbooking.R
import com.example.sharedbooking.RegistrationActivity
import com.example.sharedbooking.entities.User
import com.google.gson.Gson

class RegistrationFragment : Fragment() {
    private lateinit var login: TextView
    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editAge: EditText
    private lateinit var editCity: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editName = view.findViewById(R.id.regName)
        editEmail = view.findViewById(R.id.regEmail)
        editAge = view.findViewById(R.id.regAge)
        editCity = view.findViewById(R.id.regCity)
        editPassword = view.findViewById(R.id.regPassword)
        btnRegister = view.findViewById(R.id.btnRegister)
        text = view.findViewById(R.id.textWrong)
        login = view.findViewById(R.id.loginText)

        btnRegister.setOnClickListener {
            val name = editName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val age = editAge.text.toString().trim()
            val city = editCity.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (name.isNotEmpty()) {
                if (email.isNotEmpty()){
                    if (age.isNotEmpty()){
                        if (city.isNotEmpty()){
                            if (password.isNotEmpty()){
                                val userId = System.currentTimeMillis()
                                val user = User(name, email, password = password, userId = userId)
                                DataBase.newUser(user)
                                CurrentUser.user = user
                                val prefs = requireContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                                prefs.edit().putBoolean("isRegistered", true).apply()
                                val editor = prefs.edit()
                                val gson = Gson()
                                   val userJson = gson.toJson(user)
                                editor.putString("user_json", userJson)
                                editor.apply()

                                val intent = Intent(requireContext(), MainActivity::class.java)
                                startActivity(intent)
                            }else{
                                text.text = text.text.toString() + "пароль"
                            }
                        }else{
                            text.text = text.text.toString() + "город"
                        }
                    }else{
                        text.text = text.text.toString() + "возраст"
                    }
                }else{
                    text.text = text.text.toString() + "почту"
                }
            }else{
                text.text = text.text.toString() + "имя"
            }
            text.visibility = TextView.VISIBLE
        }
        login.setOnClickListener {
            (requireActivity() as? RegistrationActivity)?.replaceFragment(LoginFragment())
        }
    }
}