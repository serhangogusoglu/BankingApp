package com.example.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import com.example.bankingapp.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() {
    private var _binding: FragmentContactUsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.popBackStack()
        }

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.sendMessage.setOnClickListener {
            // Tüm alanları temizle
            binding.name.text?.clear()
            binding.email.editText?.text?.clear()
            binding.phone.text?.clear()
            binding.message.editText?.text?.clear()

            Toast.makeText(context, "Thank you for your feedback.", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }

    }

}