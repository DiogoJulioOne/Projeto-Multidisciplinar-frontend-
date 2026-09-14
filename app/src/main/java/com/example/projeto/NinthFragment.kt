package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projeto.databinding.FragmentNinthBinding

class NinthFragment : Fragment() {

    private var _binding: FragmentNinthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNinthBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNotificacoes.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Notificações em breve",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnPrivacidade.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Privacidade em breve",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnAjuda.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Central de ajuda em breve",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnTermos.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Termos de uso em breve",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Voltar para o Perfil
        binding.btnVoltarPerfil.setOnClickListener {
            findNavController().navigate(
                R.id.action_NinthFragment_to_ThirdFragment
            )
        }

        // Sair da conta
        binding.btnSair.setOnClickListener {
            findNavController().navigate(
                R.id.action_NinthFragment_to_FirstFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}