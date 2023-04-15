package com.example.sk_works.navigation.bottomNav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.account.Account
import com.example.sk_works.screens.cart.Cart
import com.example.sk_works.screens.customizeProduct.CustomizeProduct
import com.example.sk_works.screens.home.Home
import com.example.sk_works.screens.mainScreen.myOrderScreen.MyOrders
import com.example.sk_works.screens.placeOrder.PlaceOrderScreen
import com.example.sk_works.screens.productDetailScreen.ProductDetailScreen


@Composable
fun BottomNavGraph(navController: NavHostController,padding : PaddingValues){
    NavHost(navController = navController, startDestination = NavScreen.Home.name){

        composable(NavScreen.Home.name){
            Home(navController = navController)
        }

        composable(NavScreen.MyOrders.name){
            MyOrders()
        }

        composable(NavScreen.Cart.name){
            Cart()
        }

        composable(NavScreen.Account.name){
            Account()
        }

//        innerNavGraph(navController)
        
        composable(NavScreen.ProductDetail.name){
            ProductDetailScreen(navController = navController)
        }

        composable(NavScreen.CustomizeProduct.name){
            CustomizeProduct(navController = navController)
        }

        composable(route = NavScreen.PlaceOrderScreen.name){
            PlaceOrderScreen()
        }
    }
}

fun NavGraphBuilder.innerNavGraph(navController: NavHostController){
    navigation(startDestination = NavScreen.ProductDetail.name, route = "inner"){
        composable(route = NavScreen.ProductDetail.name){
            ProductDetailScreen(navController = navController)
        }

        composable(route = NavScreen.PlaceOrderScreen.name){
            PlaceOrderScreen()
        }
    }
}