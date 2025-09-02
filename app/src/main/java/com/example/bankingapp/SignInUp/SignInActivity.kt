package com.example.bankingapp.SignInUp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bankingapp.MainActivity
import com.example.bankingapp.Onboarding3Activity
import com.example.bankingapp.R
import com.example.bankingapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.password.filters = arrayOf(InputFilter.LengthFilter(6))

        binding.backIcon.setOnClickListener {
            startActivity(Intent(this, Onboarding3Activity::class.java))
            finish()
        }

        binding.signInButton.setOnClickListener {
            val emailText = binding.email.text.toString().trim()
            val passwordText = binding.password.text.toString().trim()

            var sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)


            // Email kontrolü
            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                binding.emailLayout.error = getString(R.string.emailWarn)
                return@setOnClickListener
            } else {
                binding.emailLayout.error = null
            }

            // Şifre kontrolü (en az 6 karakter)
            if (passwordText.length < 6) {
                binding.passwordLayout.error = getString(R.string.pwdWarn)
                return@setOnClickListener
            } else {
                binding.passwordLayout.error = null
            }

            if (emailText == savedEmail && passwordText == savedPassword) {
                Toast.makeText(this, getString(R.string.signInSuccess), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, getString(R.string.invalidEmailOrPassword), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        // Kullanıcı password alanına odaklanırsa hata kalksın
        binding.password.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.passwordLayout.error = null
        }

        binding.email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.emailLayout.error = null
        }

        binding.tvSignIn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}
