package com.example.mykotlinapp.network.api

import android.util.Log
import com.example.mykotlinapp.network.entities.SportsCategories
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("getMerchantOrders/{wallet_id}/{page}/{per_page}")
    suspend fun getpagedCategories(
        @Path("wallet_id") id: Int,
        @Path("page") page: Int,
        @Path("per_page") per_page: Int
    ): List<SportsCategories> = emptyList()


    companion object {
//        private const val BASE_URL = ConstantValues.ECOMMERCE_URL + "api/"

        fun create(): ApiService {
            val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.e("Retrofit2 Errors", "message: $message")
                }
            })
//            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//            val apiInterceptor = API_Interceptor.Builder()
//                .consumerKey(Utilities.getMd5Hash(ConstantValues.ECOMMERCE_CONSUMER_KEY))
//                .consumerSecret(Utilities.getMd5Hash(ConstantValues.ECOMMERCE_CONSUMER_SECRET))
//                .consumerIP(ConstantValues.getLocalIpAddress())
//                .build()
//
//            val basicOAuthWoocommerce = BasicOAuth.Builder()
//                .consumerKey(ConstantValues.ECOMMERCE_CONSUMER_KEY)
//                .consumerSecret(ConstantValues.ECOMMERCE_CONSUMER_SECRET)
//                .consumerIP(ConstantValues.getLocalIpAddress())
//                .build()
//
//            val okHttpClient = OkHttpClient().newBuilder()
//                .connectTimeout(5, TimeUnit.MINUTES)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS) //.addInterceptor(apiInterceptor)
//                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(object : Interceptor {
//                    @Throws(IOException::class)
//                    override fun intercept(chain: Interceptor.Chain): Response {
//                        val request = chain.request().newBuilder() // .addHeader(Constant.Header, authToken)
//                            .build()
//                        return chain.proceed(request)
//                    }
//                })
//                .addInterceptor(if (BASE_URL.startsWith("https://")) apiInterceptor else basicOAuthWoocommerce)
//                .build()
//
//
            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create<ApiService>(ApiService::class.java)
        }
    }
}