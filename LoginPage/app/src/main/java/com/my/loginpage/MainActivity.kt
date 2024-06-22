package com.my.loginpage

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var errorText: TextView
    lateinit var notRobotCheckBox: CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        errorText = findViewById(R.id.errorMessage)
        notRobotCheckBox = findViewById(R.id.notRobotCheckBox)

        login.setOnClickListener {
            validateDetails()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun validateDetails() {
        when {
            username.text.isNullOrEmpty() -> {
                errorText.text = "User name cannot be empty"
                errorText.visibility = TextView.VISIBLE
            }
            password.text.isNullOrEmpty() -> {
                errorText.text = "Password cannot be empty"
                errorText.visibility = TextView.VISIBLE
            }
            username.text.toString() == "Sahan" && password.text.toString() == "Sahan123" -> {
                errorText.visibility = TextView.GONE
                notRobotCheckBox.visibility = CheckBox.VISIBLE
                Log.i("MainActivity", "Login success")
            }
            else -> {
                errorText.text = "Wrong user name or password"
                errorText.visibility = TextView.VISIBLE
                notRobotCheckBox.visibility = CheckBox.GONE
                Log.e("MainActivity", "Wrong user name or password")
            }
        }
    }
}
