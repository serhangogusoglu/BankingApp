package com.example.bankingapp.SignInUp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
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


        // Sign up butonuna basıldıgında
        binding.signInButton.setOnClickListener {
            val fullName = binding.fullName.text.toString().trim()
            val phone = binding.phoneNumber.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if(fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.length < 6) {
                Toast.makeText(this, "Tüm alanları doğru şekilde doldurun", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("email", email)
                putString("password", password)
                apply()
            }

            Toast.makeText(this, "Kayıt Başarılı! Giriş Yapabilirsiniz.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
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