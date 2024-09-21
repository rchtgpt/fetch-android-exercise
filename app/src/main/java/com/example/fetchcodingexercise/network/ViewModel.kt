package com.example.fetchcodingexercise.network

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchcodingexercise.models.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing the UI-related data in the MainScreen.
 * It handles fetching, filtering, and sorting items from the API.
 */
class MainViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    init {
        fetchItems()
    }

    /**
     * Fetches the list of items from the API.
     * Runs the following operations:
     * 1. Displays all the items grouped by "listId"
     * 2. Sorts the results first by "listId" then by "name" when displaying.
     * 3. Filter out any items where "name" is blank or null.
     */
    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getItems()
                Log.d("API Response", "Received ${response.size} items: $response")
                val filterOutNullOrBlankNameResponse = response.filter { !it.itemName.isNullOrBlank() }
                val sortedResponse = filterOutNullOrBlankNameResponse
                    .sortedWith(compareBy<Item> { it.itemNumber }.thenBy { it.itemName })
                _items.value = sortedResponse
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching items", e)
            }
        }
    }
}