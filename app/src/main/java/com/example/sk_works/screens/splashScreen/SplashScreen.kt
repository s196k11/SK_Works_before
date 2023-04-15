package com.example.sk_works.screens.splashScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sk_works.navigation.navScreen.NavScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController){



    LaunchedEffect(key1 = true, block = {
        delay(1500)

        navHostController.navigate(NavScreen.SignIn.name){
            popUpTo(NavScreen.Splash.name){
                inclusive = true
            }
        }
    })

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "SK Works", fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}