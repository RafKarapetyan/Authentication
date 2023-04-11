package com.example.homeact

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.homeact.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)



        binding.loginButton.setOnClickListener {

            val prefs = PreferansesMeneger(applicationContext)

            val currentUser = binding.emailEditText.text.toString()
            val currentPassword = binding.passwordEditText.text.toString()
            val userName = prefs.getUsername(currentUser)
            val password = prefs.getPassword(currentPassword)

            if (currentUser == userName && currentPassword== password) {
                val intent = Intent(this, SucsessActivity::class.java)
                startActivity(intent)

            }


        }
    }
}