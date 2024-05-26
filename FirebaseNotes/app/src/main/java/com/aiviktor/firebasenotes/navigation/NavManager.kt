package com.aiviktor.firebasenotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aiviktor.firebasenotes.viewModels.LoginViewModel
import com.aiviktor.firebasenotes.viewModels.NotesViewModel
import com.aiviktor.firebasenotes.views.login.BlankView
import com.aiviktor.firebasenotes.views.login.TabsView
import com.aiviktor.firebasenotes.views.notes.AddNoteView
import com.aiviktor.firebasenotes.views.notes.HomeView

@Composable
fun NavManager(loginVM: LoginViewModel, notesVM: NotesViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Blank") {
        composable("Blank") {
            BlankView(navController)
        }
        composable("Login") {
            TabsView(navController, loginVM)
        }
        composable("Home") {
            HomeView(navController, notesVM)
        }
        composable("AddNote") {
            AddNoteView(navController, notesVM)
        }
    }
}