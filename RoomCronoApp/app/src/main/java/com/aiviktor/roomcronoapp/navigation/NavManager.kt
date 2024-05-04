package com.aiviktor.roomcronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aiviktor.roomcronoapp.viewmodel.CronometroViewModel
import com.aiviktor.roomcronoapp.viewmodel.CronosViewmodel
import com.aiviktor.roomcronoapp.views.AddView
import com.aiviktor.roomcronoapp.views.EditView
import com.aiviktor.roomcronoapp.views.HomeView

@Composable
fun NavManager(cronometroVM: CronometroViewModel, cronosVM: CronosViewmodel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController, cronosVM)
        }
        composable("AddView"){
            AddView(navController,cronometroVM, cronosVM)
        }
        composable("EditView/{id}", arguments = listOf(
            navArgument("id"){type = NavType.LongType}
        )){
            val id = it.arguments?.getLong("id")?:0
            EditView(navController, cronometroVM, cronosVM, id)
        }
    }
}