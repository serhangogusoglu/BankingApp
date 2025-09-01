package com.example.bankingapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class Onboarding1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding1)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener{
            val intent = Intent(this@Onboarding1Activity, Onboarding2Activity::class.java)
            startActivity(intent)
        }

    }
}