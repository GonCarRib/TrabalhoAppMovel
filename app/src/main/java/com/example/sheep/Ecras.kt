package com.example.sheep


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Icon
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.sheep.ui.theme.backgroundBotaoColor
import com.example.sheep.ui.theme.backgroundColor



@Composable
fun EcraHome(modifier: Modifier = Modifier,  viewModel: MainViewModel, gameDeals : List<GameDeal>,Stores : List<Store>,navController: NavHostController) {
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
                gameDeal,
                viewModel = viewModel,
                Stores = Stores,
                navController

            )
        }
    }
    InfoDeal()
}




@Composable
fun EcraWishlist(allWishlists: List<WishlistGame>, searchResults: List<WishlistGame>, viewModel: MainViewModel,Stores : List<Store>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.backgroundColor)
            .padding(top = 65.dp)
            .padding(10.dp)
    ) {
        items(allWishlists) { wishlistGame ->
            WishlistButton(
                wishlistGame,
                viewModel = viewModel,
                Stores = Stores
            )
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
fun GameDealButton(gameDeal: GameDeal, viewModel: MainViewModel,Stores : List<Store>,navController: NavHostController) {

    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.backgroundBotaoColor),
        onClick = {
            //navController.navigate(Destino.EcraWishlist.route)
            viewModel.insertWishlist(WishlistGame(
                gameDeal.internalName,
                gameDeal.title ,
                gameDeal.metacriticLink ,
                gameDeal.dealID ,
                gameDeal.storeID ,
                gameDeal.gameID ,
                5f , //LastPrice meter depois
                gameDeal.salePrice,
                gameDeal.normalPrice ,
                //gameDeal.OnSale  ,
                "1",
                gameDeal.savings ,
                gameDeal.metacriticScore ,
                gameDeal.steamRatingText ,
                gameDeal.steamRatingPercent ,
                gameDeal.steamRatingCount ,
                gameDeal.steamAppID ,
                gameDeal.releaseDate ,
                gameDeal.lastChange ,
                gameDeal.dealRating ,
                gameDeal.thumb

            /*
                "",
                "",
                "",
                "",
                "",
                "",
                0f,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                0,
                "",
                ""
            */

            )
        )
        },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {


            /*Icon(
                painterResource(R.drawable.ic_launcher_background),
                modifier = Modifier.padding(start = 15.dp, end = 10.dp),
                contentDescription = null,
                tint =  Color.White
            )*/
            val store = Stores.find { it.storeID == gameDeal.storeID}

                AsyncImage(
                    model =  "https://www.cheapshark.com/" + store!!.images.logo ,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).padding(top = 10.dp, start = 10.dp)
                )



            Spacer(modifier = Modifier.padding(end = 35.dp))

            Text(
                gameDeal.title,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically).weight(35f)
            )

            Spacer(modifier = Modifier.padding(end = 70.dp))

            Text(
                gameDeal.salePrice.toString() + "€",
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically).weight(10f)
            )
        }
    }
}


@Composable
fun WishlistButton(wishlistGame: WishlistGame, viewModel: MainViewModel,Stores : List<Store>) {
    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.backgroundBotaoColor),
        onClick = {
            viewModel.deleteWishlist(
                wishlistGame.dealID
            )
        },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            /*Icon(
                painterResource(R.drawable.baseline_android_24),
                modifier = Modifier.padding(start = 15.dp, end = 10.dp),
                contentDescription = null,
                tint =  Color.White
            )*/

            val store = Stores.find { it.storeID == wishlistGame.storeID}

            AsyncImage(
                model =  "https://www.cheapshark.com/" + store!!.images.logo ,
                contentDescription = null,
                modifier = Modifier.size(40.dp).padding(top = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.padding(end = 25.dp))

            Text(
                wishlistGame.title,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically).weight(35f)
            )

            Spacer(modifier = Modifier.padding(end = 70.dp))


            if (wishlistGame.salePrice.toFloat()<wishlistGame.lastPrice){
                Text(
                    wishlistGame.salePrice + "€",
                    color = Color.Green,
                    modifier = Modifier.align(Alignment.CenterVertically).weight(10f)
                )
            }else{
                Text(
                    wishlistGame.salePrice + "€",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterVertically).weight(10f)
                )
            }

        }
    }
}