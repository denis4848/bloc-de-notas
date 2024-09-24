package com.denisdev.notes.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.denisdev.notes.Models.loadText
import com.denisdev.notes.Models.saveText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    val context = LocalContext.current
    var text by remember { mutableStateOf(loadText(context)) } // Cargar el texto almacenado al iniciar

    Box(modifier = Modifier.background(Color(0xFFFAE493))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Notas",
                color = Color.Black,
                fontSize = androidx.compose.material3.MaterialTheme.typography.titleLarge.fontSize,
                modifier = Modifier.padding(16.dp)
            )
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                    saveText(context, newText) // Guardar el texto en SharedPreferences cada vez que cambie
                },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFFAE493), // Fondo sin foco
                    focusedContainerColor = Color(0xFFFAE493),   // Fondo con foco
                    unfocusedIndicatorColor = Color.Transparent, // Línea inferior sin foco
                    focusedIndicatorColor = Color.Transparent    // Línea inferior con foco
                ),
                placeholder = { Text("Escribir aquí...", color = Color.Gray) }
            )
        }
    }
}
