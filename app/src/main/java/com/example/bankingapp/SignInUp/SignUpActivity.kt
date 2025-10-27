package com.example.bankingapp.SignInUp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankingapp.R
import com.example.bankingapp.databinding.ActivitySignUpBinding
import java.util.Random

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.password.filters = arrayOf(InputFilter.LengthFilter(6))
        binding.phoneNumber.filters = arrayOf(InputFilter.LengthFilter(11))

        // Meslek alanı için açılır liste (AutoCompleteTextView)
        val professions = resources.getStringArray(R.array.profession_list)
        val adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, professions)
        binding.profession.setAdapter(adapter)

        binding.profession.setOnClickListener {
            binding.profession.showDropDown()
        }



        // Sign up butonuna basıldıgında
        binding.signInButton.setOnClickListener {
            val fullName = binding.fullName.text.toString().trim()
            val phone = binding.phoneNumber.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val profession = binding.profession.text.toString().trim()

            var isValid = true

            if (fullName.isEmpty()) {
                binding.fullNameLayout.error = getString(R.string.fullNameWarn)
                isValid = false
            } else {
                binding.fullNameLayout.error = null
            }

            if (phone.length != 11 || !phone.all { it.isDigit() }) {
                binding.phoneNumberLayout.error = getString(R.string.phoneNumWarn)
                isValid = false
            } else {
                binding.phoneNumberLayout.error = null
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailLayout.error = getString(R.string.emailWarn)
                isValid = false
            } else {
                binding.emailLayout.error = null
            }

            if (password.length < 6) {
                binding.passwordLayout.error = getString(R.string.pwdWarn)
                isValid = false
            } else {
                binding.passwordLayout.error = null
            }

            if (profession.isEmpty()) {
                binding.professionLayout.error = getString(R.string.professionWarn)
                isValid = false
            } else {
                binding.professionLayout.error = null
            }

            if (isValid) {

                val cardNumber = generateCardNumber()
                val expiryDate = generateExpiryDate()
                val cvv = generateCVV()

                val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("email", email)
                    putString("password", password)
                    putString("fullName", fullName)
                    putString("cardNumber", cardNumber)
                    putString("expiryDate", expiryDate)
                    putString("cvv", cvv)
                    putString("profession", profession)

                    apply()
                }

                Toast.makeText(this, getString(R.string.signUpSuccess), Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.allFieldsError),
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

    private fun generateCardNumber(): String {
        val random = Random()
        val cardNumber = StringBuilder()
        for (i in 1..16) {
            cardNumber.append(random.nextInt(10))
            if (i % 4 == 0 && i != 16) cardNumber.append(" ")
        }
        return cardNumber.toString()
    }

    private fun generateExpiryDate(): String {
        val month = (1..12).random()
        val year = (2025..2030).random()
        return String.format("%02d/%d", month, year)
    }

    private fun generateCVV(): String {
        return (100..999).random().toString()
    }
}