package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projeto.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnBuscar.setOnClickListener {

            val busca = binding.edtBusca.text.toString().trim()

            if (busca.isEmpty()) {
                binding.tvResultado.text =
                    "Digite um material para realizar a busca."
            } else {
                binding.tvResultado.text =
                    "Resultados para: $busca\n\n" +
                            "Os materiais disponíveis aparecerão aqui."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}