package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button
    lateinit var forgotPassword: TextView
    lateinit var signupLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)
        forgotPassword = findViewById(R.id.forgot_password)
        signupLink = findViewById(R.id.signup_link)

        // Add default username and password for testing
        val sharedPreferences = getSharedPreferences("LoginAppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", "SAdnan") // Replace with your test username
        editor.putString("password", "Adnan@13") // Replace with your test password
        editor.apply()

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Retrieve stored username and password
            val storedUsername = sharedPreferences.getString("username", "")
            val storedPassword = sharedPreferences.getString("password", "")

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            } else if (username == storedUsername && password == storedPassword) {
                // Show success message
                showSnackbar("Login Successful")

                // Redirect to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Close the login screen
            } else {
                // Show error message
                Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPassword.setOnClickListener {
            // Navigate to Forgot Password Activity
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        signupLink.setOnClickListener {
            // Navigate to Signup Activity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}