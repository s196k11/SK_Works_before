package com.example.sk_works.screens.shop.addProducts

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sk_works.navigation.navScreen.NavScreen

@Composable
fun NavigationTemp(navController:NavHostController,viewModel: AddProductViewModel){

    NavHost(navController = navController, startDestination = NavScreen.AddProductBasicDetail.name){
        composable(NavScreen.AddProductBasicDetail.name){
            AddProduct_basicD(navController,viewModel = viewModel)
        }

        composable(NavScreen.AddProductDesign.name){
            AddProductDesign(navController,viewModel = viewModel)
        }

        composable(NavScreen.AddProductDescription.name){
            AddProductDescription(viewModel = viewModel)
        }

        composable(NavScreen.AddProductPreview.name){
            AddProductPreview(viewModel = viewModel)
        }


    }
}
