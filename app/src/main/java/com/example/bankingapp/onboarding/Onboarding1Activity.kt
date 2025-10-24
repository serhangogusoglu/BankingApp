package com.example.bankingapp.onboarding

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.bankingapp.R

class Onboarding1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding1)

        val nextButton = findViewById<Button>(R.id.nextButton1)
        nextButton.setOnClickListener{
            val intent = Intent(this@Onboarding1Activity, Onboarding2Activity::class.java)
            startActivity(intent)
        }

    }
}