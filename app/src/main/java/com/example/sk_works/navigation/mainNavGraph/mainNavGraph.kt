package com.example.sk_works.navigation.mainNavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.mainScreen.MainScreen
import com.example.sk_works.screens.splashScreen.SplashScreen
import com.example.sk_works.navigation.navScreen.NavGraphs
import com.example.sk_works.screens.signUpSignIn.forgetPassword.EnterOtpScreen
import com.example.sk_works.screens.signUpSignIn.forgetPassword.ResetPasswordScreen
import com.example.sk_works.screens.signUpSignIn.forgetPassword.SetNewPassword
import com.example.sk_works.screens.signUpSignIn.signIn.SignInScreen
import com.example.sk_works.screens.signUpSignIn.singUp.SignUpScreen


@Composable
fun MainGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = NavScreen.Splash.name, route = NavGraphs.MainGraph.name){

        composable(NavScreen.Splash.name){
            SplashScreen(navHostController)
        }



        composable(NavScreen.Main.name){
            MainScreen()
        }

        loginGraph(navHostController)

    }
}


fun NavGraphBuilder.loginGraph(navController: NavController){
    navigation(NavScreen.SignIn.name, route = "login"){

        composable(NavScreen.SignIn.name){
            SignInScreen(navController)
        }

        composable(NavScreen.SignUp.name){
            SignUpScreen(navController)
        }

        composable(NavScreen.ResetPassword.name){
            ResetPasswordScreen(navController)
        }

        composable(NavScreen.EnterOtpScreen.name){
            EnterOtpScreen(navController)
        }

        composable(NavScreen.SetNewPassword.name){
            SetNewPassword(navController)
        }
    }
}