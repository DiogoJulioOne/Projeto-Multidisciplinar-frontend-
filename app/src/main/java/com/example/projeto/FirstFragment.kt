package com.example.projeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.projeto.api.RetrofitClient
import com.example.projeto.databinding.FragmentFirstBinding
import com.example.projeto.model.LoginRequest
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEntrar.setOnClickListener {

            val email = binding.edtEmail.text.toString().trim()
            val senha = binding.edtSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            fazerLogin(email, senha)
        }
    }

    private fun fazerLogin(
        email: String,
        senha: String
    ) {
        viewLifecycleOwner.lifecycleScope.launch {

            try {
                val usuario = LoginRequest(
                    email = email,
                    password = senha
                )

                val resposta = RetrofitClient.api.login(usuario)

                if (resposta.isSuccessful) {

                    Toast.makeText(
                        requireContext(),
                        "Login realizado com sucesso!",
                        Toast.LENGTH_LONG
                    ).show()

                } else {

                    Toast.makeText(
                        requireContext(),
                        "E-mail ou senha incorretos",
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