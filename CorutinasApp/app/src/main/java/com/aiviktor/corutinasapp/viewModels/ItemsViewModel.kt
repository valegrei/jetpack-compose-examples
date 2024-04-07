package com.aiviktor.corutinasapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiviktor.corutinasapp.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsViewModel : ViewModel() {
    //flow
    private val _lista: MutableStateFlow<List<ItemsModel>> = MutableStateFlow(emptyList())
    val lista = _lista
    var itemList = mutableStateListOf(ItemsModel())
        private set

    var isLoading by mutableStateOf(false)
        private set

    /*init {
        fetchaData()
    }*/

    fun fetchaData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            listOf(
                ItemsModel(1, "Elemento 1"),
                ItemsModel(2, "Elemento 2"),
                ItemsModel(3, "Elemento 3"),
                ItemsModel(4, "Elemento 4"),
                ItemsModel(5, "Elemento 5"),
                ItemsModel(6, "Elemento 6"),
                ItemsModel(7, "Elemento 7"),
                ItemsModel(8, "Elemento 8"),
            )
        }
        itemList.addAll(result)
        _lista.value = result
    }

}