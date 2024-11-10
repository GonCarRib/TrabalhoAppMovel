package com.example.sheep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sheep.ui.theme.SheepTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SheepTheme{
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.backgroundColor)
                        .padding(top = 65.dp)
                        .padding(10.dp)
                ) {
                    items(20) {
                        BotaoDeal()
                    }
                }
                InfoDeal()
            }
        }
    }
}


@Composable
fun BotaoDeal() {
    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.backgroundBotaoColor),
        onClick = { onClick() },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                alignment = Alignment.CenterStart,
                contentDescription = null
            )
            Spacer(
                modifier = Modifier
                    .width(15.dp)
            )
            Text(
                "Buy Batman: Arkham Knight",
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)

            )
            Spacer(
                modifier = Modifier
                    .width(45.dp)
            )
            Text(
                "20.00€",
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun InfoDeal() {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .height(50.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.backgroundBotaoColor)
            .padding(start = 15.dp , end = 5.dp)

    )
    {
        Row(
        )
        {
            Text(
                "Loja",
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()


            )
            Spacer(
                modifier = Modifier
                    .width(15.dp)
            )
            Text(
                "Jogo",
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(alignment = Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier
                    .width(150.dp)
            )
            Text(
                "Preço",
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()
                    .align(alignment = Alignment.CenterVertically)
            )
        }

    }

}

fun onClick() {
    //haha
}



