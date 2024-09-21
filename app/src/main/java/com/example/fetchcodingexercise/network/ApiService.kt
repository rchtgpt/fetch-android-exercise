package com.example.fetchcodingexercise.network

import com.example.fetchcodingexercise.models.Item
import retrofit2.http.GET

/**
 * Interface defining the API service used to fetch data from the remote server.
 *
 * This service interacts with the API endpoint to retrieve a list of items.
 */
interface ApiService {
    /**
     * Retrieves a list of items from the "hiring.json" endpoint.
     *
     * @return A [List] of [Item] objects representing the fetched items.
     */
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}