package com.example.activity_4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import java.lang.reflect.Modifier


@Composable
fun Praktikum() {
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan"
    val statusOption = listOf("Menikah", "Belum Menikah", "Jomblo"))

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
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
}






