package com.example.sheep

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.sheep.ui.theme.SheepTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.sheep.ui.theme.backgroundBotaoColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SheepTheme{

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val owner = LocalViewModelStoreOwner.current
                    owner?.let {
                        val viewModel: MainViewModel = viewModel(
                            it,
                            "MainViewModel",
                            MainViewModelFactory(
                                LocalContext.current.applicationContext
                                        as Application
                            )
                        )
                        ScreenSetup(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}

fun getData(deals: MutableList<GameDeal>, context: Context) {
    val retrofitClient = NetworkUtils
        .getRetrofitInstance("https://www.cheapshark.com/")

    val endpoint = retrofitClient.create(Endpoint::class.java)
    val callback = endpoint.getDeals()

    callback.enqueue(object : Callback<List<GameDeal>> {
        override fun onFailure(call: Call<List<GameDeal>>, t: Throwable) {
            Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<List<GameDeal>>, response: Response<List<GameDeal>>) {
            response.body()?.let { dealList ->
                deals.clear()
                deals.addAll(dealList.map {it})
            }
        }
    })
}

@Composable
fun ScreenSetup(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                modifier = modifier,
                appItems = Destino.toList,
                ) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                AppNavigation(
                    navController = navController,
                    modifier = modifier,
                    viewModel = viewModel
                    )
            }
        }
    )
}


class MainViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }
}

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val allWishlists by viewModel.allWishlists.observeAsState(listOf())
    val searchResults by viewModel.searchResults.observeAsState(listOf())
    val deals = remember { mutableStateListOf<GameDeal>() }
    val context = LocalContext.current
    getData(deals, context)
    NavHost(navController, startDestination = Destino.EcraHome.route) {
        composable(Destino.EcraHome.route) {
            EcraHome(
                modifier = modifier,
                viewModel = viewModel,
                gameDeals = deals
            )
        }
        composable(Destino.EcraWishlist.route) {
            EcraWishlist(
                allWishlists = allWishlists,
                searchResults = searchResults,
                viewModel = viewModel
            )
        }
        /*composable(Destino.EcraGame.route) {
            EcraHome()
        }*/
    }
}



@Composable
fun BottomNavigationBar(
    navController: NavController,
    appItems: List<Destino>,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier.height(90.dp),
        backgroundColor = MaterialTheme.colorScheme.backgroundBotaoColor,
        contentColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        appItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(R.drawable.baseline_android_24),
                        modifier = Modifier.size(60.dp).padding(top = 10.dp, bottom = 10.dp),
                        contentDescription = item.title,
                        tint = if (currentRoute == item.route) Color.White else Color.White.copy(.2F)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (currentRoute == item.route) Color.White else Color.White.copy(.2F)
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}











