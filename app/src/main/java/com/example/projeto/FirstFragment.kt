package com.example.projeto

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.projeto.api.RetrofitClient
import com.example.projeto.data.TokenManager
import com.example.projeto.databinding.FragmentFirstBinding
import com.example.projeto.model.LoginRequest
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var tokenManager: TokenManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tokenManager = TokenManager(requireContext())

        RetrofitClient.initialize(tokenManager)

        binding.btnEntrar.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            val loginRequest = LoginRequest(
                email = email,
                password = senha
            )

            viewLifecycleOwner.lifecycleScope.launch {

                try {

                    val response = RetrofitClient.api.login(loginRequest)

                    Log.d("API", "Código: ${response.code()}")

                    if (response.isSuccessful) {

                        val token = response.body()?.token

                        if (token != null) {

                            tokenManager.saveToken(token)

                            Log.d("API", "Token salvo!")

                            findNavController().navigate(
                                R.id.action_FirstFragment_to_ThirdFragment
                            )

                        } else {

                            Log.e("API", "Resposta não possui token")

                        }

                    } else {

                        Log.e(
                            "API",
                            "Login falhou: ${response.errorBody()?.string()}"
                        )

                    }

                } catch (e: Exception) {

                    Log.e(
                        "API",
                        "Erro na requisição",
                        e
                    )
                }
            }
        }

        binding.tvCadastro.setOnClickListener {

            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}