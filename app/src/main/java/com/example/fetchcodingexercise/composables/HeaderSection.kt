package com.example.fetchcodingexercise.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable function that renders the header section of the app, including a greeting,
 * a submission note, and a button to open my website on the browser.
 *
 */
@Composable
fun HeaderSection() {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF3F1A52), shape = RoundedCornerShape(6.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BasicText(
                    text = "🐕",
                    style = TextStyle(fontSize = 24.sp)
                )

                Spacer(modifier = Modifier.width(8.dp))
                val text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append("Howdy, good humans at ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFBA819),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append("fetch")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append("!")
                    }
                }

                // Title
                Text(
                    text = text
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "This is Rachit Gupta's coding exercise submission for the Android Internship role.",
                fontSize = 16.sp,
                color = Color(0xFFE5E5E5)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    uriHandler.openUri("http://rchtgpt.com")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(6.dp),
            ) {
                Text(
                    text = "Checkout my projects: http://rchtgpt.com",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

        }
    }
}