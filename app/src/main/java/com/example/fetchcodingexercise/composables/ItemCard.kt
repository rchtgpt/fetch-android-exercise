package com.example.fetchcodingexercise.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A composable function that displays a card with an item’s title, ID, and count.
 *
 * The card has a dynamic color depending on the value of `count` and includes an
 * outlined box displaying the count.
 *
 * @param title The title of the item to be displayed.
 * @param id The unique ID of the item.
 * @param count The list number associated with the item, which is used to determine the card’s accent color.
 */
@Composable
fun ItemCard(title: String, id: Int, count: Int) {
    // Determine color based on the count value
    val dynamicColor = when (count) {
        1 -> Color(0xFF4CAF50) // green color
        2 -> Color(0xFFFFC107) // gold color
        3 -> Color(0xFF2196F3) // blue color
        4 -> Color(0xFFF44336) // red color
        else -> Color(0xFFF44336)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(6.dp) // Reduce corner radius here
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Colored line on the left based on the count
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(4.dp)
                    .background(dynamicColor) // Dynamic color for the line
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f) // Take up the remaining space
            ) {
                // Title
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black// Dynamic color for the text
                )

                // ID
                Text(
                    text = "ID: $id",
                    fontSize = 16.sp,
                    color = Color.Black.copy(alpha = 0.7f) // Dynamic, slightly lighter color for the ID text
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Count box (Outlined) with dynamic color
            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        dynamicColor,
                        shape = RoundedCornerShape(8.dp)
                    ) // Outlined box with dynamic color
                    .padding(8.dp)
            ) {
                Text(
                    text = count.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = dynamicColor // Color matching the outline and the line on the left
                )
            }
        }
    }
}