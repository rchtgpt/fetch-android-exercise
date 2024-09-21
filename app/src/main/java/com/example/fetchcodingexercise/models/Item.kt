package com.example.fetchcodingexercise.models
import com.google.gson.annotations.SerializedName

/**
 * Data class representing an item retrieved from the API.
 *
 * Each item contains a name, an ID, and a list number. The fields are mapped from the JSON response using
 * Gson's @SerializedName annotation to match the API's JSON structure.
 *
 * @property itemName The name of the item (can be null).
 * @property itemId The unique ID of the item.
 * @property itemNumber The list number the item belongs to.
 */
data class Item(
    @SerializedName("name") val itemName: String?,
    @SerializedName("id") val itemId: Int,
    @SerializedName("listId") val itemNumber: Int)