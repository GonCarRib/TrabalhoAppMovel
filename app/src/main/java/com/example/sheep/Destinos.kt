package com.example.sheep

sealed class Destino(val route: String, val icon: Int, val title: String) {
    object EcraHome : Destino(route = "ecra_home", icon = R.drawable.home, title = "Home")
    object EcraWishlist : Destino(route = "ecra_wishlist", icon = R.drawable.wishlist, title = "Whislist")
    object EcraGame : Destino(route = "ecra_game", icon = R.drawable.ic_launcher_foreground, title = "Game")
    object EcraGameStore : Destino(route = "ecra_game_store", icon = R.drawable.ic_launcher_foreground, title = "GameStore")

    companion object {
        val toList = listOf(EcraHome, EcraWishlist/*, EcraGame*/)
    }
}