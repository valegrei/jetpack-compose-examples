package com.aiviktor.roomcronoapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aiviktor.roomcronoapp.R
import com.aiviktor.roomcronoapp.components.CircleButton
import com.aiviktor.roomcronoapp.components.MainIconButton
import com.aiviktor.roomcronoapp.components.MainTextField
import com.aiviktor.roomcronoapp.components.MainTitle
import com.aiviktor.roomcronoapp.components.formatTiempo
import com.aiviktor.roomcronoapp.model.Cronos
import com.aiviktor.roomcronoapp.viewmodel.CronometroViewModel
import com.aiviktor.roomcronoapp.viewmodel.CronosViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(
    navController: NavController,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewmodel
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "ADD CRONO") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        },
    ) {
        ContentAddView(it, navController, cronometroVM, cronosVM)
    }
}

@Composable
fun ContentAddView(
    it: PaddingValues,
    navController: NavController,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewmodel
) {

    val state = cronometroVM.state

    LaunchedEffect(state.cronometroActivo) {
        cronometroVM.cronos()
    }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTiempo(cronometroVM.tiempo),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            //Iniciar
            CircleButton(
                icon = painterResource(id = R.drawable.play),
                enabled = !state.cronometroActivo
            ) {
                cronometroVM.iniciar()
            }

            //Pausar
            CircleButton(
                icon = painterResource(id = R.drawable.pausa),
                enabled = state.cronometroActivo
            ) {
                cronometroVM.pausar()
            }

            //Detener
            CircleButton(
                icon = painterResource(id = R.drawable.stop),
                enabled = !state.cronometroActivo
            ) {
                cronometroVM.detener()
            }

            //Mostrar guardar
            CircleButton(
                icon = painterResource(id = R.drawable.save),
                enabled = state.showSaveButton
            ) {
                cronometroVM.showTextField()
            }
        }

        if (state.showTextField) {
            MainTextField(
                value = state.title,
                onValueChange = { cronometroVM.onValue(it) },
                label = "Title"
            )

            Button(onClick = {
                cronosVM.addCrono(
                    Cronos(
                        title = state.title,
                        crono = cronometroVM.tiempo
                    )
                )
                cronometroVM.detener()
                navController.popBackStack()
            }){
                Text(text = "Guardar")
            }
        }
    }
}