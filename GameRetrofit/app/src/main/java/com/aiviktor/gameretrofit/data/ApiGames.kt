package com.aiviktor.gameretrofit.data

import com.aiviktor.gameretrofit.model.GameModel
import com.aiviktor.gameretrofit.model.SingleGameModel
import com.aiviktor.gameretrofit.util.Constants.Companion.API_KEY
import com.aiviktor.gameretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GameModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<SingleGameModel>
}