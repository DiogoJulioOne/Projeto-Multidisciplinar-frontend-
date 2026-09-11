package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.projeto.api.RetrofitClient
import com.example.projeto.databinding.FragmentSecondBinding
import com.example.projeto.model.RegisterRequest
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrar.setOnClickListener {

            val nome = binding.edtNome.text.toString().trim()
            val email = binding.edtEmailCadastro.text.toString().trim()
            val senha = binding.edtSenhaCadastro.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            cadastrar(nome, email, senha)
        }
    }

    private fun cadastrar(
        nome: String,
        email: String,
        senha: String
    ) {
        viewLifecycleOwner.lifecycleScope.launch {

            try {
                val usuario = RegisterRequest(
                    name = nome,
                    email = email,
                    password = senha
                )

                val resposta = RetrofitClient.api.register(usuario)

                if (resposta.isSuccessful) {

                    Toast.makeText(
                        requireContext(),
                        "Cadastro realizado com sucesso!",
                        Toast.LENGTH_LONG
                    ).show()

                } else {

                    Toast.makeText(
                        requireContext(),
                        "Erro ao cadastrar: ${resposta.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {

                Toast.makeText(
                    requireContext(),
                    "Erro de conexão com o servidor",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}