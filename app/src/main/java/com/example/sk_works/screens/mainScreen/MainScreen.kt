package com.example.sk_works.screens.mainScreen



import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sk_works.navigation.bottomNav.BottomNavGraph
import com.example.sk_works.navigation.bottomNav.BottomNavigation

@Preview(showSystemUi = true)
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController)}
    ){ padding ->
        BottomNavGraph(navController = navController,padding)
    }
}