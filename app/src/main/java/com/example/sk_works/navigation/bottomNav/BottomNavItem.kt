package com.example.sk_works.navigation.bottomNav

import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen

sealed class BottomNavItem(var title:String,var icon:Int,var fIcon:Int,var screen_route:String){

    object Home: BottomNavItem("Home",R.drawable.home, R.drawable.fhome,NavScreen.Home.name)
    object MyOrders: BottomNavItem("My Orders",R.drawable.order, R.drawable.forder,NavScreen.MyOrders.name)
    object Cart: BottomNavItem("Cart",R.drawable.shopping_cart, R.drawable.fshopping_cart,NavScreen.Cart.name)
    object Account:BottomNavItem("Account",R.drawable.profile, R.drawable.fprofile,NavScreen.Account.name)
}
