package com.aiviktor.loteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.aiviktor.loteria.ui.theme.LoteriaTheme
import com.aiviktor.loteria.viewModels.ContadorViewModel
import com.aiviktor.loteria.viewModels.LoteriaViewModel
import com.aiviktor.loteria.views.Contador
import com.aiviktor.loteria.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val viewModel: ContadorViewModel by viewModels()
        val viewModel: LoteriaViewModel by viewModels()

        setContent {
            LoteriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Contador(viewModel)
                    LoteriaView(viewModel)
                }
            }
        }
    }
}
