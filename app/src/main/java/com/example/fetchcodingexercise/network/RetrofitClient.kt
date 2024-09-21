package com.example.fetchcodingexercise.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton object that provides a Retrofit client configured to interact with the API service.
 *
 * This object initializes a Retrofit instance with the base URL and a Gson converter for JSON deserialization.
 */
object RetrofitClient {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    /**
     * Lazy-initialized Retrofit API service instance.
     *
     * This property initializes Retrofit only when first accessed.
     */
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
