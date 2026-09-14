package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projeto.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(
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

        // CONFIGURAÇÕES
        binding.btnConfiguracoes.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_NinthFragment
            )
        }

        // EDITAR PERFIL
        binding.btnEditarPerfil.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_TenthFragment
            )
        }

        // PUBLICAR MATERIAL
        binding.btnPublicarMaterial.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_FourthFragment
            )
        }

        // BUSCAR MATERIAIS
        binding.btnBuscarMateriais.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_FifthFragment
            )
        }

        // MEUS ANÚNCIOS
        binding.btnMeusMateriais.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_SixthFragment
            )
        }

        // MATCHES
        binding.btnMatches.setOnClickListener {
            findNavController().navigate(
                R.id.action_ThirdFragment_to_SeventhFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}