package com.example.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchcodingexercise.composables.MainScreen
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

/**
 * Main activity of the Fetch Coding Exercise app.
 *
 * This activity sets the content of the app using Jetpack Compose and applies the
 * FetchCodingExerciseTheme.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     * this bundle contains the data it most recently supplied.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchCodingExerciseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * A composable function used to preview the MainScreen in Android Studio's preview pane.
 */
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FetchCodingExerciseTheme {
        MainScreen()
    }
}