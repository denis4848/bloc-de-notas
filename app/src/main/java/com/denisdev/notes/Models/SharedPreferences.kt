package com.denisdev.notes.Models

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

private const val PREFS_NAME = "MyAppPreferences"
private const val KEY_TEXT = "text_key"

fun saveText(context: Context, text: String) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    with(sharedPreferences.edit()) {
        putString(KEY_TEXT, text)
        apply()
    }
}

fun loadText(context: Context): String {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString(KEY_TEXT, "") ?: ""
}
