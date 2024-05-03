package com.aiviktor.roomcronoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.aiviktor.roomcronoapp.navigation.NavManager
import com.aiviktor.roomcronoapp.ui.theme.RoomCronoAppTheme
import com.aiviktor.roomcronoapp.viewmodel.CronometroViewModel
import com.aiviktor.roomcronoapp.viewmodel.CronosViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cronometroVM : CronometroViewModel by viewModels()
        val cronosVM : CronosViewmodel by viewModels()
        setContent {
            RoomCronoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(cronometroVM, cronosVM)
                }
            }
        }
    }
}
