package com.example.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bankingapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Language arrow -> Bottom Sheet
        binding.arrowRight.setOnClickListener {
            val bottomSheet = LanguageBottomSheetFragment()
            bottomSheet.show(parentFragmentManager, "LanguageBottomSheetFragment")
        }

        // Profile arrow -> Profile Fragment

        binding.arrowRightProfile.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.arrowRightChangePassword.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ChangePasswordFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.arrowRightPrivacyPolicy.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PrivacyPolicyFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.arrowRightContactUs.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ContactUsFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.exitIcon.setOnClickListener {
            val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            builder.setTitle("Exit App")
            builder.setMessage("Are you sure you want to exit the app?")

            // Evet butonu
            builder.setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                requireActivity().finish() // Uygulamayı kapat
            }

            // Hayır butonu
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss() // Sadece popup kapansın
            }

            // Dialog göster
            val dialog = builder.create()
            dialog.show()
        }

        val sharedPrefs = requireContext().getSharedPreferences("AppSettings",android.content.Context.MODE_PRIVATE)
        val selectedLanguage = sharedPrefs.getString("selectedLanguage", "en") // varsayılan

        val languageText = when(selectedLanguage) {
            "tr" -> "Türkçe"
            "de" -> "Deutsch"
            "fr" -> "Français"
            "en" -> "English"
            else -> "English"
        }

        binding.languageDeger.text = languageText


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
