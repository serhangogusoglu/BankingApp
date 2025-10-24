package com.example.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bankingapp.databinding.FragmentLanguageBottomSheetBinding
import com.example.bankingapp.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Locale

class LanguageBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentLanguageBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLanguageBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Dil seçimi
        binding.tvEnglish.setOnClickListener { changeLanguage("en") }
        binding.tvTurkish.setOnClickListener { changeLanguage("tr") }
        binding.tvDeutsch.setOnClickListener { changeLanguage("de") }
        binding.tvFrancais.setOnClickListener { changeLanguage("fr") }
    }

    private fun changeLanguage(langCode: String) {
        //Locale değiştir
        LocaleHelper.setLocale(requireContext(), langCode)

        //seçili dili kaydet
        val sharedPrefs = requireContext().getSharedPreferences("AppSettings", android.content.Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString("selectedLanguage", langCode)
        editor.apply()

        //Uygulama yeniden başlat
        val intent = requireActivity().intent
        requireActivity().finish()
        startActivity(intent)

        dismiss() // bottomsheet kapat
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null   // memory leak önlemek için
    }
}