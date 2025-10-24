package com.example.bankingapp.splashActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bankingapp.R
import com.example.bankingapp.onboarding.Onboarding1Activity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        // 3 saniye bekledikten sonra Onboarding1Activity'ye geç
        lifecycleScope.launch {
            delay(3000) // 3000 ms = 3 saniye
            val intent = Intent(this@SplashActivity, Onboarding1Activity::class.java)
            startActivity(intent)
            finish() // Splash ekranını kapat
        }
    }
}
