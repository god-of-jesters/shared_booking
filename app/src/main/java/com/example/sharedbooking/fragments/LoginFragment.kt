package com.example.sharedbooking.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class LoginFragment : Fragment() {
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var registrationText: TextView
    private lateinit var wrongLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editEmail = view.findViewById(R.id.emailLogin)
        editPassword = view.findViewById(R.id.passwordLogin)
        loginButton = view.findViewById(R.id.loginButton)
        registrationText = view.findViewById(R.id.regLogin)
        wrongLogin = view.findViewById(R.id.wrongLogin)

        loginButton.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()
            if (email.isNotEmpty()){
                if (password.isNotEmpty()){
                    DataBase.checkUserIn(email, password) { u ->
                        if (u != null){
                            CurrentUser.user = u
                            saveUserToPrefs(requireContext(), u)
                            val intent = Intent(requireContext(), MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
            wrongLogin.text = "Неправильная почта или пароль"
        }
        registrationText.setOnClickListener {
            (requireActivity() as? RegistrationActivity)?.replaceFragment(RegistrationFragment())
        }
    }

    fun saveUserToPrefs(context: Context, user: User) {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("isRegistered", true).apply()
        val editor = prefs.edit()
        val gson = Gson()
        val userJson = gson.toJson(user)
        editor.putString("user_json", userJson)
        editor.apply()
    }
}