package com.example.activity_4

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember



@Composable
fun Praktikum() {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    Column {
        Text("Formulir Pendaftaran")

        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            label = { Text("Nama Lengkap") }
        )

        OutlinedTextField(
            value = textAlamat,
            onValueChange = { textAlamat = it },
            label = { Text("Alamat") }
        )
    }
}





