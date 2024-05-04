package com.aiviktor.gameretrofit.repository

import com.aiviktor.gameretrofit.data.ApiGames
import com.aiviktor.gameretrofit.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {
    suspend fun  getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if(response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}