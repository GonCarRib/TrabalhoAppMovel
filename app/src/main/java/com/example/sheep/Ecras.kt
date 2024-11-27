package com.example.sheep

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.example.sheep.ui.theme.backgroundBotaoColor
import com.example.sheep.ui.theme.backgroundColor

@Composable
fun EcraHome(
    state: WishlistState,
    onEvent: (WishEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.backgroundColor)
            .padding(top = 65.dp)
            .padding(10.dp)
    ) {
        items(gameDeals) { gameDeal ->
            GameDealButton(
                onEvent,
                gameDeal
            )
        }
    }
    InfoDeal()
}

@Composable
fun EcraWishlist(
    state: WishlistState,
    onEvent: (WishEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.backgroundColor)
            .padding(top = 65.dp)
            .padding(10.dp)
    ) {
        items(state.wishlist) { wishlistGame ->
            WishlistButton(wishlistGame)
        }
    }
    InfoDeal()
}


@Composable
fun InfoDeal() {
    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .height(50.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.backgroundBotaoColor)
            .padding(start = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            "Store",
            color = Color.White,
            modifier = Modifier
        )

        VerticalDivider(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxHeight()
                .width(1.dp),
            color = Color.White
        )

        Text(
            "Game",
            color = Color.White,
            modifier = Modifier
        )

        VerticalDivider(
            modifier = Modifier
                .padding(start = 160.dp , end = 15.dp)
                .fillMaxHeight()
                .width(1.dp),
            color = Color.White
        )
        Text(
            "Price",
            color = Color.White,
            modifier = Modifier
        )
    }

}

@Composable
fun GameDealButton(
    onEvent: (WishEvent) -> Unit,
    gameDeal: GameDeal
) {
    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.backgroundBotaoColor),
        onClick = {
            onEvent(WishEvent.SetDealID(gameDeal.dealID))
            onEvent(WishEvent.SetDealID(gameDeal.dealID))
            onEvent(WishEvent.SetInternalName(gameDeal.internalName))
            onEvent(WishEvent.SetTitle(gameDeal.title))
            onEvent(WishEvent.SetMetacriticLink(gameDeal.metacriticLink))
            onEvent(WishEvent.SetStoreID(gameDeal.storeID))
            onEvent(WishEvent.SetGameID(gameDeal.gameID))
            onEvent(WishEvent.SetSalePrice(gameDeal.salePrice))
            onEvent(WishEvent.SetNormalPrice(gameDeal.normalPrice))
            onEvent(WishEvent.SetIsOnSale(gameDeal.isOnSale))
            onEvent(WishEvent.SetSavings(gameDeal.savings))
            onEvent(WishEvent.SetMetacriticScore(gameDeal.metacriticScore))
            onEvent(WishEvent.SetSteamRatingText(gameDeal.steamRatingText))
            onEvent(WishEvent.SetSteamRatingPercent(gameDeal.steamRatingPercent))
            onEvent(WishEvent.SetSteamRatingCount(gameDeal.steamRatingCount))
            onEvent(WishEvent.SetSteamAppID(gameDeal.steamAppID))
            onEvent(WishEvent.SetReleaseDate(gameDeal.releaseDate))
            onEvent(WishEvent.SetLastChange(gameDeal.lastChange))
            onEvent(WishEvent.SetDealRating(gameDeal.dealRating))
            onEvent(WishEvent.SetThumb(gameDeal.thumb))
            onEvent(WishEvent.SaveWish)
        },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                alignment = Alignment.CenterStart
            )

            Spacer(modifier = Modifier.padding(end = 25.dp))

            Text(
                gameDeal.title,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.padding(end = 70.dp))

            Text(
                gameDeal.salePrice.toString() + "€",
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}


@Composable
fun WishlistButton(wishlistGame: wishlistGame) {
    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.backgroundBotaoColor),
        onClick = {

        },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                alignment = Alignment.CenterStart
            )

            Spacer(modifier = Modifier.padding(end = 25.dp))

            Text(
                wishlistGame.title,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.padding(end = 70.dp))
            if (wishlistGame.salePrice<wishlistGame.lastPrice){
                Text(
                    wishlistGame.salePrice.toString() + "€",
                    color = Color.Green,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }else{
                Text(
                    wishlistGame.salePrice.toString() + "€",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

        }
    }
}