package com.example.bankingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bankingapp.models.Transaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankingapp.adapter.TransactionAdapter
import com.example.bankingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val cardNumber = sharedPref.getString("cardNumber", "0000 0000 0000 0000")
        val expiryDate = sharedPref.getString("expiryDate", "00/00")
        val cvv = sharedPref.getString("cvv", "000")
        val fullName = sharedPref.getString("fullName", "Guest")

        binding.tvCardNumber.text = cardNumber
        binding.tvCardExpiry.text = expiryDate
        binding.tvCardCvv.text = cvv
        binding.tvCardName.text = fullName
        binding.tvUserName.text = fullName

        // Transaction RecyclerView
        transactionAdapter = TransactionAdapter(getDummyTransactions())
        binding.rvTransactions.adapter = transactionAdapter
        binding.rvTransactions.layoutManager = LinearLayoutManager(this)

        // Bottom Navigation örnek
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> true
                R.id.cards -> true
                R.id.statistics -> true
                R.id.settings -> true
                else -> false
            }
        }
    }

    private fun getDummyTransactions(): List<Transaction> {
        return listOf(
            Transaction("Apple Store", "Entertainment", "- $5.99", R.drawable.apple_svgrepo_com),
            Transaction("Spotify", "Music", "- $12.99", R.drawable.spotify_color_svgrepo_com),
            Transaction(
                "Money Transfer",
                "Transaction",
                "+ $300",
                R.drawable._money_receive_svgrepo_com
            ),
            Transaction("Grocery", "Food", "- $88", R.drawable.grocery_store_bakery_svgrepo_com)
        )
    }
}
