package com.aiviktor.intentapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aiviktor.intentapp.views.EmailView
import com.aiviktor.intentapp.views.PhoneView
import com.aiviktor.intentapp.views.SMSView

@Composable
fun NavManager(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Routes.PhoneView.route) {
        composable(Routes.PhoneView.route){
            PhoneView()
        }
        composable(Routes.SMSView.route){
            SMSView()
        }
        composable(Routes.EmailView.route){
            EmailView()
        }
    }
}