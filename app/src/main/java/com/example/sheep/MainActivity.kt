package com.example.sheep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sheep.ui.theme.SheepTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room



class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            this,
            wishlistDatabase::class.java,
            "wishlist.db"
        ).build()
    }
    private val viewModel by viewModels<WishlistViewModel>(
        factoryProducer = {
            object  : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(model:Class<T>):T{
                    return WishlistViewModel(db.dao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SheepTheme{
                val state by viewModel.state.collectAsState()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProgramaPrincipal(state,viewModel::onEvent)
                }
            }
        }
    }
}



@Composable
fun ProgramaPrincipal(
    state: WishlistState,
    onEvent: (WishEvent) -> Unit,
) {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, appItems = Destino.toList) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                AppNavigation(navController = navController,state,onEvent)
            }
        }
    )
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    state: WishlistState,
    onEvent: (WishEvent) -> Unit,) {

    NavHost(navController, startDestination = Destino.EcraHome.route) {
        composable(Destino.EcraHome.route) {
            EcraHome(state,onEvent)
        }
        composable(Destino.EcraWishlist.route) {
            EcraWishlist(state,onEvent)
        }
        composable(Destino.EcraGame.route) {
            EcraHome(state,onEvent)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, appItems: List<Destino>) {
    BottomNavigation(backgroundColor = colorResource(id = R.color.purple_700),contentColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        appItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, tint=if(currentRoute == item.route) Color.White else Color.White.copy(.2F)) },
                label = { Text(text = item.title, color = if(currentRoute == item.route) Color.White else Color.White.copy(.2F)) },
                //selectedContentColor = Color.White, // esta instrução devia funcionar para o efeito (animação), para o ícone e para a cor do texto, mas só funciona para o efeito
                //unselectedContentColor = Color.White.copy(0.4f), // esta instrução não funciona, por isso resolve-se acima no 'tint' do icon e na 'color' da label
                alwaysShowLabel = true, // colocar 'false' significa que o texto só aparece debaixo do ícone selecionado (em vez de debaixo de todos)
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route -> popUpTo(route) { saveState = true } }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}










