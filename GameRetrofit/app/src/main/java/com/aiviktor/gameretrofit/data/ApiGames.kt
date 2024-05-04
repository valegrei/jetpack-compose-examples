package com.aiviktor.gameretrofit.data

import com.aiviktor.gameretrofit.model.GameModel
import com.aiviktor.gameretrofit.util.Constants.Companion.API_KEY
import com.aiviktor.gameretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GameModel>
}