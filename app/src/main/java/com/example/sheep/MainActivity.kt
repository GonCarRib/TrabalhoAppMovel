package com.example.sheep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sheep.ui.theme.SheepTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SheepTheme{
                //EcraHome()
                EcraWishlist()
            }
        }
    }
}










