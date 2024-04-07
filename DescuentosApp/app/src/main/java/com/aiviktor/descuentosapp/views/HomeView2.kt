@file:OptIn(ExperimentalMaterial3Api::class)

package com.aiviktor.descuentosapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aiviktor.descuentosapp.components.Alert
import com.aiviktor.descuentosapp.components.MainButton
import com.aiviktor.descuentosapp.components.MainTextField
import com.aiviktor.descuentosapp.components.SpaceH
import com.aiviktor.descuentosapp.components.TwoCards
import com.aiviktor.descuentosapp.viewModels.CalcularViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView2(viewModel2: CalcularViewModel2) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "App Descuentos",
                        color = Color.White
                    )
                }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        HomeContent2(it, viewModel2)
    }
}

@Composable
fun HomeContent2(paddingValues: PaddingValues, viewModel2: CalcularViewModel2) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center
    ) {
        TwoCards(
            title1 = "Total",
            number1 = viewModel2.totalDescuento,
            title2 = "Descuento",
            number2 = viewModel2.precioDescuento
        )

        MainTextField(
            value = viewModel2.precio,
            onValueChange = { viewModel2.onValue(it, "precio") },
            label = "Precio"
        )
        SpaceH()
        MainTextField(
            value = viewModel2.descuento,
            onValueChange = { viewModel2.onValue(it, "descuento") },
            label = "Descuento %"
        )
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel2.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel2.limpiar()
        }

        if (viewModel2.showAlert) {
            Alert(
                title = "Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel2.cancelAlert() }) {}
        }
    }
}
