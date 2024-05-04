package com.aiviktor.gameretrofit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiviktor.gameretrofit.model.GameList
import com.aiviktor.gameretrofit.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repo: GamesRepository) : ViewModel()  {
    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    init {
        fetchGames()
    }

    private fun fetchGames(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getGames()
            _games.value = result ?: emptyList()
        }
    }
}