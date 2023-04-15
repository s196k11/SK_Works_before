package com.example.sk_works

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sk_works.navigation.mainNavGraph.MainGraph
import com.example.sk_works.screens.shop.addProducts.AddProductViewModel
import com.example.sk_works.screens.shop.addProducts.NavigationTemp
import com.example.sk_works.ui.theme.SK_WorksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<AddProductViewModel>()
            val navController = rememberNavController()
//            NavigationTemp(navController, viewModel = viewModel)
            MainGraph(navHostController = navController)


        }
    }
}

//use below function to active dark theme
//SK_WorksTheme() {
//
//}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SK_WorksTheme {
        Greeting("Android")
    }
}