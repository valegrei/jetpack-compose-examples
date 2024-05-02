package com.aiviktor.roomcronoapp.state

data class CronoState(
    val cronometroActivo: Boolean = false,
    val showSaveButton: Boolean = false,
    val showTextField: Boolean = false,
    val title: String = ""
)
