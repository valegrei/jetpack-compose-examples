package com.aiviktor.gameretrofit.model

data class GameModel(
    val count: Int,
    val results: List<GameList>
)

data class GameList(
    val id: Int,
    val name: String,
    val background_image: String
)
