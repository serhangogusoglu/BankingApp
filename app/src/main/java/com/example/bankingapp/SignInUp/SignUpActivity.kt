package com.example.bankingapp.SignInUp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bankingapp.R
import com.example.bankingapp.databinding.ActivitySignInBinding
import com.example.bankingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.password.filters = arrayOf(InputFilter.LengthFilter(6))
        binding.phoneNumber.filters = arrayOf(InputFilter.LengthFilter(11))


        // Sign up butonuna basıldıgında
        binding.signInButton.setOnClickListener {
            val fullName = binding.fullName.text.toString().trim()
            val phone = binding.phoneNumber.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            var isValid = true

            if (fullName.isEmpty()) {
                binding.fullNameLayout.error = "Lütfen Geçerli Bir İsim Giriniz."
                isValid = false
            } else {
                binding.fullNameLayout.error = null
            }

            if (phone.length != 11 || !phone.all { it.isDigit() }) {
                binding.phoneNumberLayout.error = "Telefon 11 haneli olmalı."
                isValid = false
            } else {
                binding.phoneNumberLayout.error = null
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailLayout.error = "Lütfen Geçerli Bir E-mail Giriniz."
                isValid = false
            } else {
                binding.emailLayout.error = null
            }

            if (password.length < 6) {
                binding.passwordLayout.error = "Şifreniz en az 6 karakter olmalı."
                isValid = false
            } else {
                binding.passwordLayout.error = null
            }

            if (isValid) {
                val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("email", email)
                    putString("password", password)
                    apply()
                }

                Toast.makeText(this, "Kayıt Başarılı! Giriş Yapabilirsiniz.", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Lütfen tüm alanlardaki hataları düzeltin.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Zaten hesabın varsa sign in sayfasına git
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.backIcon.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}