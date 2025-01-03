package com.example.sheep.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ColorScheme



val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val fundo = Color(0xFF14181B)
val fundoBotao = Color(0xFF1D2428)

val ColorScheme.backgroundColor: Color
    get() = fundo

val ColorScheme.backgroundBotaoColor: Color
    get() = fundoBotao

