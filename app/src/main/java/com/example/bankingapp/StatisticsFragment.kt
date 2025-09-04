package com.example.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankingapp.adapter.TransactionAdapter
import com.example.bankingapp.databinding.FragmentStatisticsBinding
import com.example.bankingapp.models.Transaction

class StatisticsFragment : Fragment() {

    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // İşlem listesini oluşturan ve RecyclerView'a bağlayan fonksiyonu çağır
        setupTransactions()
    }

    /**
     * Örnek işlem listesi oluşturur ve RecyclerView'ı ayarlar.
     */
    private fun setupTransactions() {
        // İşlemler için örnek veri listesi oluştur
        val transactions = listOf(
            Transaction("Apple Store", "Entertainment", "-$5.99", R.drawable.apple_svgrepo_com),
            Transaction("Spotify", "Music", "-$12.99", R.drawable.spotify_color_svgrepo_com),
            Transaction("Money Transfer", "Transaction", "$300", R.drawable.grocery_store_bakery_svgrepo_com)
        )

        // TransactionAdapter'ı oluştur ve veri listesini ver
        val adapter = TransactionAdapter(transactions)

        // RecyclerView için LinearLayoutManager'ı ayarla
        binding.rvTransactions.layoutManager = LinearLayoutManager(requireContext())

        // RecyclerView'a adaptörü bağla
        binding.rvTransactions.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Bellek sızıntısını önlemek için binding'i null yap
        _binding = null
    }
}