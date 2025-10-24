package com.example.bankingapp.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bankingapp.HomeFragment
import com.example.bankingapp.MyCardsFragment
import com.example.bankingapp.R
import com.example.bankingapp.SettingsFragment
import com.example.bankingapp.statisticsFragment.StatisticsFragment
import com.example.bankingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Başlangıçta HomeFragment yükle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()

        // BottomNavigation ile fragment geçişi
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.home -> HomeFragment()
                R.id.cards -> MyCardsFragment()
                R.id.statistics -> StatisticsFragment()
                R.id.settings -> SettingsFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, it)
                    .commit()
            }
            true
        }
    }
}
