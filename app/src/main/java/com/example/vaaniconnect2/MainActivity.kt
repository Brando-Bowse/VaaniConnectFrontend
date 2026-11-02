package com.example.vaaniconnect2 // Make sure this matches your project's package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF2C2C2C) // Dark background matching your screenshot
                ) {
                    TranslationScreen()
                }
            }
        }
    }
}

@Composable
fun TranslationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(31.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Upper section containing the two translation cards
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TranslationCard(languageText = "Language 1")
            TranslationCard(languageText = "Language 2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Navigation Bar
        BottomActionBar()
    }
}

@Composable
fun TranslationCard(languageText: String) {
    var text by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(375.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3A3A))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Top row of card: Dropdown and Microphone Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Language Dropdown Mock
                    Box(
                        modifier = Modifier
                            .width(220.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF5A5A5A))
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.width(220.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = languageText, color = Color.White, fontSize = 16.sp)
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown", tint = Color.White)
                        }
                    }

                    // Microphone Button
                    IconButton(
                        onClick = { /* Handle Mic Click */ },
                        modifier = Modifier
                            .size(65.dp)
                            .background(Color(0xFF6C6C6C), shape = CircleShape)
                    ) {
                        Icon(Icons.Default.Mic, contentDescription = "Mic", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Text Input Area Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF4A4A4A))
                        .padding(4.dp)
                ) {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        modifier = Modifier.fillMaxSize(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }
            }

            // Speaker Button positioned precisely at the bottom-right of the card
            IconButton(
                onClick = { /* Handle Speaker Click */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(28.dp)
                    .size(65.dp)
                    .background(Color(0xFF6C6C6C), shape = CircleShape)
            ) {
                Icon(Icons.Default.VolumeUp, contentDescription = "Speaker", tint = Color.White)
            }
        }
    }
}

@Composable
fun BottomActionBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF3A3A3A))
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Translate action */ }) {
            Icon(Icons.Default.Translate, contentDescription = "Translate", tint = Color.White, modifier = Modifier.size(32.dp))
        }
        IconButton(onClick = { /* Camera action */ }) {
            Icon(Icons.Default.PhotoCamera, contentDescription = "Camera", tint = Color.White, modifier = Modifier.size(32.dp))
        }
        IconButton(onClick = { /* Menu action */ }) {
            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White, modifier = Modifier.size(32.dp))
        }
    }
}
