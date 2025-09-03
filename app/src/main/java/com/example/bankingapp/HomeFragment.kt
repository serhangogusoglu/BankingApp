package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankingapp.adapter.TransactionAdapter
import com.example.bankingapp.databinding.FragmentHomeBinding
import com.example.bankingapp.models.Transaction

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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

        binding.tvCardNumber.text = cardNumber
        binding.tvCardExpiry.text = expiryDate
        binding.tvCardCvv.text = cvv
        binding.tvCardName.text = fullName
        binding.tvUserName.text = fullName

        // Transaction RecyclerView
        transactionAdapter = TransactionAdapter(getDummyTransactions())
        binding.rvTransactions.adapter = transactionAdapter
        binding.rvTransactions.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getDummyTransactions(): List<Transaction> {
        return listOf(
            Transaction("Apple Store", "Entertainment", "- $5.99", R.drawable.apple_svgrepo_com),
            Transaction("Spotify", "Music", "- $12.99", R.drawable.spotify_color_svgrepo_com),
            Transaction("Money Transfer", "Transaction", "+ $300", R.drawable._money_receive_svgrepo_com),
            Transaction("Grocery", "Food", "- $88", R.drawable.grocery_store_bakery_svgrepo_com)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
