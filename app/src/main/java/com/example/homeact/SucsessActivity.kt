package com.example.homeact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeact.databinding.ActivityLoginBinding
import com.example.homeact.databinding.ActivitySucsessBinding

class SucsessActivity : AppCompatActivity() {
    lateinit var binding:ActivitySucsessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySucsessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}