package com.example.sheep

sealed class Destino(val route: String, val icon: Int, val title: String) {
    object EcraHome : Destino(route = "ecra01", icon = R.drawable.ic_launcher_foreground, title = "Home")
    object EcraWishlist : Destino(route = "ecra02", icon = R.drawable.ic_launcher_foreground, title = "Whislist")
    object EcraGame : Destino(route = "ecra03", icon = R.drawable.ic_launcher_foreground, title = "Game")

    companion object {
        val toList = listOf(EcraHome, EcraWishlist/*, EcraGame*/)
    }
}