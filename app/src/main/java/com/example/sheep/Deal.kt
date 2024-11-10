package com.example.sheep

import android.media.Image

data class Deal(
    val id : Int,
    val loja : Image,
    val nome : String,
    val preco : Float
)