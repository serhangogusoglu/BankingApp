package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankingapp.adapter.TransactionAdapter
import com.example.bankingapp.databinding.FragmentMyCardsBinding
import com.example.bankingapp.models.Transaction

class MyCardsFragment : Fragment() {

    private var _binding: FragmentMyCardsBinding? = null
    private val binding get() = _binding!!
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SharedPreferences'den kullanıcı bilgisi al
        val sharedPref = requireActivity().getSharedPreferences("UserData", AppCompatActivity.MODE_PRIVATE)
        val cardNumber = sharedPref.getString("cardNumber", "0000 0000 0000 0000")
        val expiryDate = sharedPref.getString("expiryDate", "00/00")
        val cvv = sharedPref.getString("cvv", "000")
        val fullName = sharedPref.getString("fullName", "Guest")

        // Kart bilgilerini ekrana bas
        binding.tvCardNumber.text = cardNumber
        binding.tvCardExpiry.text = expiryDate
        binding.tvCardCvv.text = cvv
        binding.tvCardName.text = fullName

        // Harcama Limiti Görünümü İçin Kodlar
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Örneğin, 10,000$ limiti için 100 ile çarpıp tutarı dinamik olarak güncelliyoruz.
                val amount = 100 * progress
                binding.tvCurrentAmount.text = "$${String.format("%,d", amount)}"
                binding.tvAmount.text = "Amount: $${String.format("%,d", amount)}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Dokunma başladığında yapılacaklar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Dokunma bittiğinde yapılacaklar
            }
        })

        // SeekBar için başlangıç değerlerini ayarlayın
        binding.seekBar.max = 100 // Maksimum 10000$ için 100'e ayarlayın
        binding.seekBar.progress = 46 // 4600$ için 46'ya ayarlayın
        binding.tvCurrentAmount.text = "$4,600" // Başlangıçta 4600$ göster
        binding.tvAmount.text = "Amount: $8,545.00" // Başlangıçta 8545$ göster

        // Transaction RecyclerView
        transactionAdapter = TransactionAdapter(getDummyTransactions())
        binding.rvTransactions.adapter = transactionAdapter
        binding.rvTransactions.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getDummyTransactions(): List<Transaction> {
        return listOf(
            Transaction("Apple Store", "Entertainment", "- $5.99", R.drawable.apple_svgrepo_com),
            Transaction("Spotify", "Music", "- $12.99", R.drawable.spotify_color_svgrepo_com),
            Transaction("Grocery", "Food", "- $88", R.drawable.grocery_store_bakery_svgrepo_com)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}