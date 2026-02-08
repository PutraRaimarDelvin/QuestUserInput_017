package com.example.activity_4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment


@Composable
fun Praktikum() {
    var textJK by remember { mutableStateOf("") }
    val gender = listOf("Laki-laki", "Perempuan")

    Column {
        Text("Jenis Kelamin")

        gender.forEach {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = textJK == it,
                    onClick = { textJK = it }
                )
                Text(it)
            }
        }
    }
}






