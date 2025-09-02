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
            Transaction("Apple Store", "Entertainment", "- $5.99", R.drawable.baseline_airlines_24),
            Transaction("Spotify", "Music", "- $12.99", R.drawable.baseline_music_note_24),
            Transaction("Money Transfer", "Transaction", "+ $300", R.drawable.baseline_money_24),
            Transaction("Grocery", "Food", "- $88", R.drawable.baseline_add_shopping_cart_24)
        )
    }
}
