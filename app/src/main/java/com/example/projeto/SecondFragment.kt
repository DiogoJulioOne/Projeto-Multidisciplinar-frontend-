package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projeto.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // CRIAR CONTA
        binding.btnCadastrar.setOnClickListener {

            val nome = binding.edtNome.text.toString().trim()

            if (nome.isEmpty()) {

                Toast.makeText(
                    requireContext(),
                    "Digite seu nome",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            Toast.makeText(
                requireContext(),
                "Conta criada com sucesso!",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigate(
                R.id.action_SecondFragment_to_ThirdFragment
            )
        }

        // VOLTAR PARA LOGIN
        binding.tvVoltarLogin.setOnClickListener {

            findNavController().navigate(
                R.id.action_SecondFragment_to_FirstFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}