package com.example.activity_4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Praktikum(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val statusOption = listOf("Menikah", "Belum Menikah", "Jomblo")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.biru_muda))
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(colorResource(id = R.color.biru))
        ) {

            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )

            IconButton(
                onClick = {
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(16.dp)
                    .size(42.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = colorResource(id = R.color.biru)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .shadow(10.dp, RoundedCornerShape(18.dp))
                .clip(RoundedCornerShape(18.dp))
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text("NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = textNama,
                onValueChange = { textNama = it },
                placeholder = { Text("Masukkan nama lengkap") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Text("JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        Text(item)
                    }
                }
            }

            Text("STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
            statusOption.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textStatus == item,
                        onClick = { textStatus = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textStatus == item,
                        onClick = { textStatus = item }
                    )
                    Text(item)
                }
            }

            Text("ALAMAT", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = textAlamat,
                onValueChange = { textAlamat = it },
                placeholder = { Text("Masukkan alamat") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                enabled = textAlamat.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.abu_tua),
                    disabledContainerColor = Color.LightGray
                ),
                onClick = {
                    nama = textNama
                    jenis = textJK
                    status = textStatus
                    alamat = textAlamat
                }
            ) {
                Button(
                    enabled = textAlamat.isNotEmpty(),
                    onClick = {}
                ) {
                    Text("Submit")
                }

            }
        }
    }
}