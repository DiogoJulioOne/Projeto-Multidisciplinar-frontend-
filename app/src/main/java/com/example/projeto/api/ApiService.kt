package com.example.projeto.api

import com.example.projeto.model.LoginRequest
import com.example.projeto.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("users/register")
    suspend fun register(
        @Body user: RegisterRequest
    ): Response<Unit>

    @POST("users/login")
    suspend fun login(
        @Body user: LoginRequest
    ): Response<Unit>

    @GET("products/announces")
    suspend fun getAnnounces(): Response<Unit>
}