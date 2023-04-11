@file:Suppress("DEPRECATION")

package com.example.homeact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homeact.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = PreferansesMeneger(applicationContext)
        binding.apply {
            imageButtonBack.setOnClickListener {
                val intent = Intent(this@Register,MainActivity::class.java)
                startActivity(intent)
            }

            buttonCreateAccount.setOnClickListener {
                if (checkValidation()) {
                    val userName = usernameEditText.text.toString()
                    val email = emailEditText.text.toString()
                    val phone = phoneEditText.text.toString()
                    val pass = passwordEditText.text.toString()
                    val pass1 = confirmEditText.text.toString()
                    sharedPref.putUsername(userName)
                    sharedPref.putPassword(pass)


                    val intent = Intent(this@Register, SucsessActivity::class.java)
                    startActivity(intent)
                }
            }

        }

    }

    private fun checkValidation(): Boolean {
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val conform = binding.confirmEditText.text.toString()
        val phone = binding.phoneEditText.text.toString()


        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || conform.isEmpty()) {
            Toast.makeText(this, "Please fill the details", Toast.LENGTH_SHORT).show()
            return false
        }
            // comparing two passwords are same using compareTo
            if (password == conform) {
                return if (isValid(password)) {
                    true
                } else {
                    Toast.makeText(
                        this,
                        "Password must contain at least 8 characters, One UpperCase letter, digit and special symbol",
                        Toast.LENGTH_SHORT
                    ).show()
                    false
                }
            } else {
                Toast.makeText(
                    this,
                    "password and confirm password didn't match",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }

    }

    private fun isValid(password: String): Boolean {
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[0-9]).*$")
        return password.matches(passwordRegex)
    }


}










