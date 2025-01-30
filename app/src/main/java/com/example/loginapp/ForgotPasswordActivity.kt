package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.R

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var retrievePasswordBtn: Button
    lateinit var passwordDisplay: TextView

    // Hardcoded username and password for demonstration
    private val validUsername = "SAdnan"
    private val validPassword = "Adnan@13"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        usernameInput = findViewById(R.id.username_input)
        retrievePasswordBtn = findViewById(R.id.retrieve_password_btn)
        passwordDisplay = findViewById(R.id.password_display)

        retrievePasswordBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            if (username == validUsername) {
                // Display the password if the username is correct
                passwordDisplay.text = "Your password is: $validPassword"
            } else {
                // Show error message
                Toast.makeText(this, "Username not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}