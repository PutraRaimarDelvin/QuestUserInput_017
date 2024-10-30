package com.example.latihaninput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true)
@Composable
fun latihaninput(modifier: Modifier = Modifier){
    var Nama by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var NoTelpon by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("" ) }

    var Namasv by remember { mutableStateOf("") }
    var Emailsv by remember { mutableStateOf("") }
    var NoTelponsv by remember { mutableStateOf("") }
    var Alamatsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("" ) }


    val listJk = listOf("Laki-Laki", "Perempuan")
    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier .padding(16.dp))
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = Nama,
            onValueChange = {Nama = it },
            label = { Text("Nama")},
            placeholder = { Text("masukkan Nama Anda")},
        )
        Row {
            listJk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = memilihJK == item,
                    onClick = {
                        memilihJK = item
                    }
                )
                    Text(item)
                }

            }
        }
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = Email,
            onValueChange = {Email = it },
            label = { Text("Email")},
            placeholder = { Text("masukkan Email Anda")},
        )
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = NoTelpon,
            onValueChange = {NoTelpon = it },
            label = { Text("NoTelpon")},
            placeholder = { Text("masukkan NoTelpon Anda")},
        )
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = Alamat,
            onValueChange = {Alamat = it },
            label = { Text("Alamat")},
            placeholder = { Text("masukkan Alamat Anda")},
        )

        Button (onClick = {
            Namasv = Nama
            Emailsv = Email
            NoTelponsv = NoTelpon
            Alamatsv = Alamat
            memilihJKsv = memilihJK

        }) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.Green),
            modifier = Modifier
            .fillMaxWidth()

        ){
            DetailSurat(judul = "Nama", isinya = Namasv)
            DetailSurat(judul = "Email", isinya = Emailsv)
            DetailSurat(judul = "NoTelpn", isinya = NoTelponsv)
            DetailSurat(judul = "Alamat", isinya = Alamatsv)
            DetailSurat(judul = "Jenis Kelamin", isinya = memilihJKsv)


        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
    ) {
        Row {
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }


    }
}
