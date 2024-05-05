package com.aiviktor.intentapp.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.aiviktor.intentapp.components.BottomNav
import com.aiviktor.intentapp.navigation.NavManager
import com.aiviktor.intentapp.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(){
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,
        Routes.SMSView,
        Routes.EmailView
    )

    Scaffold(
        bottomBar = {
            BottomNav(navController, navigationRoutes)
        }
    ) {
        NavManager(navController)
    }
}