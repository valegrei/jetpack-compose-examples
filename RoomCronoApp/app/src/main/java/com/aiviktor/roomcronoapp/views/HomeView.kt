package com.aiviktor.roomcronoapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aiviktor.roomcronoapp.components.CronCard
import com.aiviktor.roomcronoapp.components.FloatButton
import com.aiviktor.roomcronoapp.components.MainTitle
import com.aiviktor.roomcronoapp.components.formatTiempo
import com.aiviktor.roomcronoapp.viewmodel.CronosViewmodel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, cronosVM: CronosViewmodel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "CRONO APP") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatButton {
                navController.navigate("AddView")
            }
        }
    ) {
        ContentHomeView(it = it, navController = navController, cronosVM)
    }
}

@Composable
fun ContentHomeView(it: PaddingValues, navController: NavController, cronosVM: CronosViewmodel) {
    Column(
        modifier = Modifier.padding(it)
    ) {
        val cronosList by cronosVM.cronosList.collectAsState()
        LazyColumn {
            items(cronosList) { item ->
                val delete = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Red,
                    onSwipe = {cronosVM.deleteCrono(item)}
                )

                val delete2 = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Blue,
                    onSwipe = {cronosVM.deleteCrono(item)}
                )

                SwipeableActionsBox(endActions = listOf(delete), swipeThreshold = 270.dp) {
                    CronCard(item.title, formatTiempo(item.crono)) {
                        navController.navigate("EditView")
                    }
                }

            }
        }
    }
}