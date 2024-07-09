package com.peaks.reversetaka

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.peaks.reversetaka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.etSignIn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        binding.btnPayments.setOnClickListener {
            validateRegistration()

        }
        binding.btnPayments.setOnClickListener{
            val intent=Intent(this,LandingPage::class.java)
            startActivity(intent)

        }

    }
    fun validateRegistration(){
        clearErrors()
        var formErrors=false
        val username=binding.etUsername.text.toString()
        if (username.isBlank()){
            binding.tilUsername.error="UserName is required"
        }

        val password=binding.etPassword.text.toString()
        if (username.isBlank()){
            binding.tilCreatePassword.error="Password is required"
        }
    }
    fun clearErrors(){
        binding.tilUsername.error=null
        binding.tilCreatePassword.error=null
    }
}