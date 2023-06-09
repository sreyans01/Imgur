package com.assign.imgur.utils

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit: Retrofit? = null

    /**
     * Retrofit client with Authorization parameter.
     * @param token - Authorization token or client id
     */
    fun getClientWithInterceptor(token: String?): Retrofit {

        // Create OkHttp client with default header
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val originalRequest: Request = chain.request()
            val requestBuilder: Request.Builder = originalRequest.newBuilder()
                .header("Authorization", "Client-ID " + token
                )
            val newRequest: Request = requestBuilder.build()
            chain.proceed(newRequest)
        }

        // Add logging interceptor for debugging (optional)
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        // Create Gson converter
        val gson = GsonBuilder().setLenient().create()

        // Build Retrofit instance
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        return retrofit!!
    }
}