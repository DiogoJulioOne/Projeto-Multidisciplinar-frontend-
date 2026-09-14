package com.example.projeto

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projeto.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    // Selecionar foto da galeria
    private val selecionarFoto =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {
                binding.imgMaterial.setImageURI(uri)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFourthBinding.inflate(
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

        // ==========================================
        // SELECIONAR FOTO
        // ==========================================

        binding.btnSelecionarFoto.setOnClickListener {

            selecionarFoto.launch("image/*")
        }


        // ==========================================
        // PUBLICAR MATERIAL
        // ==========================================

        binding.btnPublicar.setOnClickListener {

            // Verifica se os campos principais foram preenchidos
            val material =
                binding.edtMaterial.text.toString().trim()

            val categoria =
                binding.edtCategoria.text.toString().trim()

            val descricao =
                binding.edtDescricaoMaterial.text.toString().trim()

            val quantidade =
                binding.edtQuantidade.text.toString().trim()

            val estado =
                binding.edtEstado.text.toString().trim()

            val finalidade =
                binding.edtFinalidade.text.toString().trim()

            val localizacao =
                binding.edtLocalizacaoMaterial.text.toString().trim()


            // ==========================================
            // VALIDAÇÃO
            // ==========================================

            if (material.isEmpty()) {

                binding.edtMaterial.error =
                    "Digite o nome do material"

                binding.edtMaterial.requestFocus()

                return@setOnClickListener
            }

            if (categoria.isEmpty()) {

                binding.edtCategoria.error =
                    "Digite a categoria"

                binding.edtCategoria.requestFocus()

                return@setOnClickListener
            }

            if (descricao.isEmpty()) {

                binding.edtDescricaoMaterial.error =
                    "Digite uma descrição"

                binding.edtDescricaoMaterial.requestFocus()

                return@setOnClickListener
            }

            if (quantidade.isEmpty()) {

                binding.edtQuantidade.error =
                    "Digite a quantidade"

                binding.edtQuantidade.requestFocus()

                return@setOnClickListener
            }

            if (estado.isEmpty()) {

                binding.edtEstado.error =
                    "Informe o estado do material"

                binding.edtEstado.requestFocus()

                return@setOnClickListener
            }

            if (finalidade.isEmpty()) {

                binding.edtFinalidade.error =
                    "Informe a finalidade"

                binding.edtFinalidade.requestFocus()

                return@setOnClickListener
            }

            if (localizacao.isEmpty()) {

                binding.edtLocalizacaoMaterial.error =
                    "Informe a localização"

                binding.edtLocalizacaoMaterial.requestFocus()

                return@setOnClickListener
            }


            // ==========================================
            // PUBLICAÇÃO
            // ==========================================

            Toast.makeText(
                requireContext(),
                "Anúncio publicado com sucesso!",
                Toast.LENGTH_SHORT
            ).show()


            // ==========================================
            // IR PARA MEUS ANÚNCIOS
            // ==========================================

            findNavController().navigate(
                R.id.action_FourthFragment_to_SixthFragment
            )
        }
    }


    // ==========================================
    // LIMPAR BINDING
    // ==========================================

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }
}