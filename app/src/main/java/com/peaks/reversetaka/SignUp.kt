package com.peaks.reversetaka

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.peaks.reversetaka.databinding.ActivitySignUpBinding

class SignUp() : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.etLogIn.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener{
            validateRegistration()
        }

    }

    fun validateRegistration() {
        clearForms()
        var formsError = false
        val firstName = binding.etFirstname.text.toString()
        if (firstName.isBlank()) {
            formsError = true
            binding.tilFirstName.error = "FirstName is required"
        }
        val lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            binding.tilLastName.error = "LastName is required"
        }
        val email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }

        val password = binding.etCreatepassword.text.toString()
        if (password.isBlank()) {
            binding.tilCreatePassword.error = "Password is required"

        }

        val confirmPassword = binding.etConfirmPassword.text.toString()
        if (confirmPassword.isBlank()) {
            binding.tilConfirmPassword.error = "Confirm password is required"
        }
         if (!formsError){
             val registration=Registration(
                 firstName, lastName, email, password, confirmPassword
             )
         }

    }
    fun clearForms(){
        binding.tilFirstName.error=null
        binding.tilLastName.error=null
        binding.tilEmail.error=null
        binding.tilCreatePassword.error=null
        binding.tilConfirmPassword.error=null
    }
}