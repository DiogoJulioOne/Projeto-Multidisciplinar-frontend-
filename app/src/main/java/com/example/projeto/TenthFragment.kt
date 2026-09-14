package com.example.projeto

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class TenthFragment : Fragment() {

    // Selecionar foto da galeria
    private val selecionarFoto =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {
                view?.findViewById<ImageView>(R.id.imgFotoPerfil)
                    ?.setImageURI(uri)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_tenth,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        // =========================
        // ELEMENTOS DA TELA
        // =========================

        val imgFotoPerfil =
            view.findViewById<ImageView>(R.id.imgFotoPerfil)

        val btnSelecionarFotoPerfil =
            view.findViewById<Button>(R.id.btnSelecionarFotoPerfil)

        val btnSalvarPerfil =
            view.findViewById<Button>(R.id.btnSalvarPerfil)

        val btnVoltarPerfil =
            view.findViewById<Button>(R.id.btnVoltarPerfil)

        val edtNomePerfil =
            view.findViewById<EditText>(R.id.edtNomePerfil)

        val edtLocalizacaoPerfil =
            view.findViewById<EditText>(R.id.edtLocalizacaoPerfil)

        val edtDescricaoPerfil =
            view.findViewById<EditText>(R.id.edtDescricaoPerfil)


        // =========================
        // SELECIONAR FOTO
        // =========================

        btnSelecionarFotoPerfil.setOnClickListener {

            selecionarFoto.launch("image/*")
        }


        // =========================
        // SALVAR PERFIL
        // =========================

        btnSalvarPerfil.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Perfil atualizado!",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigate(
                R.id.action_TenthFragment_to_ThirdFragment
            )
        }


        // =========================
        // VOLTAR
        // =========================

        btnVoltarPerfil.setOnClickListener {

            findNavController().navigate(
                R.id.action_TenthFragment_to_ThirdFragment
            )
        }
    }
}