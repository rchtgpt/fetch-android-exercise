package com.example.fetchcodingexercise.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchcodingexercise.models.Item
import com.example.fetchcodingexercise.network.MainViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

/**
 * Main screen composable that displays a list of items fetched from a ViewModel.
 *
 * @param viewModel The ViewModel used to retrieve the items. Defaults to an instance of [MainViewModel].
 */
@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    // Collect the state of items from the View Model as a Composable State
    val items by viewModel.items.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        HeaderSection()

        Spacer(modifier = Modifier.height(24.dp))

        // Display Items Section
        Text(
            text = "Display Items",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn to display the list of items since we want it to be scrollable and the API returns a 1000 items
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = items) { item: Item ->
                item.itemName?.let {
                    ItemCard(
                        title = it,
                        id = item.itemId,
                        count = item.itemNumber
                    )
                }
            }
        }
    }
}
