package com.example.sharedbooking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedbooking.database.DBFirebase
import com.example.sharedbooking.entities.User

class RegistrationActivity: AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editAge: EditText
    private lateinit var editCity: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var db: DBFirebase
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.registration_activity)
        editName = findViewById(R.id.regName)
        editEmail = findViewById(R.id.regEmail)
        editAge = findViewById(R.id.regAge)
        editCity = findViewById(R.id.regCity)
        editPassword = findViewById(R.id.regPassword)
        btnRegister = findViewById(R.id.btnRegister)
        text = findViewById(R.id.textWrong)
        db = DBFirebase()

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
                                val userId = System.currentTimeMillis().toString()
                                val user = User(name, email, password = password, userId = userId)
                                db.newUser(user)

                                val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                                prefs.edit().putBoolean("isRegistered", true).apply()

                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
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
    }
}