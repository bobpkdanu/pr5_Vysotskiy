package com.bignerdranch.android.prak5_vysotskiy.ui.theme.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bignerdranch.android.prak5_vysotskiy.data.Specialty
import com.bignerdranch.android.prak5_vysotskiy.data.SpecialtyRepository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    specialtyId: Int,
    navController: NavHostController,

) {
    val contextiq = LocalContext.current
    val specialty = SpecialtyRepository.getSpecialtyById(specialtyId) ?: Specialty(
        id = 0,
        title = "Специальность не найдена",
        description = "Информация отсутствует",
        code = "—",
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("О специальности") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = specialty.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Код специальности: ${specialty.code}",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Text(
                text = "Описание",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = specialty.description,
                style = MaterialTheme.typography.bodyLarge
            )

            Button(onClick = { Click(contextiq)}){
                Text(text = "Приёмная комиссия")
            }
        }
    }
}

fun Click(context: Context) {
val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+79122801354"))
    context.startActivity(intent)
}

@Preview(showBackground = true, name = "Экран деталей")
@Composable
fun DetailScreenPreview() {
    MaterialTheme {
        DetailScreen(specialtyId = 1, navController = rememberNavController())
    }
}
