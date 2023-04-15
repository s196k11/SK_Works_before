package com.example.sk_works.navigation.bottomNav

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


//Bottom bar with hide-able  capacity
@Composable
fun BottomNavigation(navController: NavHostController) {

    val showBottomBar = rememberSaveable {mutableStateOf(true)}

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyOrders,
        BottomNavItem.Cart,
        BottomNavItem.Account
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Log.d("Current Route",currentRoute.toString())
    showBottomBar.value = items.any { it.screen_route == currentRoute }

    if (showBottomBar.value) {
        androidx.compose.material.BottomNavigation(
            backgroundColor = Color.White,
            modifier = Modifier.height(60.dp),
            elevation = 0.dp
        ) {


            items.forEach { item ->

                BottomNavigationItem(
                    selected = currentRoute == item.screen_route,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black,
                    alwaysShowLabel = true,
                    label = { Text(text = item.title) },
                    icon = {
                        if (currentRoute == item.screen_route) {
                            Icon(
                                painter = painterResource(id = item.fIcon),
                                contentDescription = item.title,
                                modifier = Modifier.size(35.dp).padding(4.dp)
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(35.dp).padding(4.dp)
                            )
                        }
                    },
                    onClick = {
                        navController.navigate(item.screen_route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

//
//@Composable
//fun BottomNavigation(navController: NavHostController) {
//
//
//
//    val items = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.MyOrders,
//        BottomNavItem.Cart,
//        BottomNavItem.Account
//    )
//
//    androidx.compose.material.BottomNavigation(
//        backgroundColor = Color.White,
//        modifier = Modifier.height(60.dp),
//        elevation = 0.dp
//    ) {
//
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//
//        items.forEach { item ->
//
//            BottomNavigationItem(
//                selected = currentRoute == item.screen_route,
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black,
//                alwaysShowLabel = true,
//                label = { Text(text = item.title) },
//                icon = {
//                    if (currentRoute == item.screen_route) {
//                        Icon(
//                            painter = painterResource(id = item.fIcon),
//                            contentDescription = item.title,
//                            modifier = Modifier.size(35.dp).padding(4.dp)
//                        )
//                    } else {
//                        Icon(
//                            painter = painterResource(id = item.icon),
//                            contentDescription = item.title,
//                            modifier = Modifier.size(35.dp).padding(4.dp)
//                        )
//                    }
//                },
//                onClick = {
//                    navController.navigate(item.screen_route) {
//                        navController.graph.startDestinationRoute?.let { screen_route ->
//                            popUpTo(screen_route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}
