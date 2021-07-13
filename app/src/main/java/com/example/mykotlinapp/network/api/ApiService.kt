package com.example.mykotlinapp.network.api

import com.example.mykotlinapp.network.entities.SportsCategories
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("getMerchantOrders/{wallet_id}/{page}/{per_page}")
    suspend fun getpagedCategories(
        @Path("wallet_id") id: Int,
        @Path("page") page: Int,
        @Path("per_page") per_page: Int
    ): List<SportsCategories> = emptyList()

}