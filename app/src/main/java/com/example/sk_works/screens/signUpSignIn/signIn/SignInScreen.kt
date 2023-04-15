package com.example.sk_works.screens.signUpSignIn.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen


//@Preview(showSystemUi = true)
@Composable
fun SignInScreen(navController: NavController) {
    val focusRequester = FocusRequester.Default
    val focusManager = LocalFocusManager.current


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFEEE8E7))) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(7.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(modifier = Modifier
                .size(150.dp)
                .background(color = Color(0xFFEEE8E7))){
                Text(text = "Select Image for here",modifier = Modifier.align(Alignment.Center))
            }

            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "Welcome Back!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.sp)
            Text(text = "We are happy to see you again.",
                fontSize = 15.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF8F7D7D)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .shadow(elevation = 3.dp, shape = CircleShape),
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF5B67DB)
                ),
                placeholder = { Text(text = "Email") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription = "Enter Email Id")
                },
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email),
                keyboardActions = KeyboardActions(onNext = {focusManager.moveFocus(focusDirection = FocusDirection.Down)})
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .shadow(elevation = 3.dp, shape = CircleShape).focusRequester(focusRequester),
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF5B67DB)
                ),
                placeholder = { Text(text = "Password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = "Enter Email Id")
                },
                trailingIcon = {},
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus(force = true)
                })
            )

            Text(text = "Forgot Password",
                fontSize = 15.sp,color = Color.Blue,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 13.dp, top = 4.dp)
                    .clickable { navController.navigate(NavScreen.ResetPassword.name)})

            Spacer(modifier = Modifier.height(15.dp))

            Button(onClick = { navController.navigate(NavScreen.Main.name) }, modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .shadow(elevation = 7.dp, shape = CircleShape),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF5B67DB)),
                shape = CircleShape
            ) {
                Text(text = "LOGIN",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp)
            }

            Spacer(modifier = Modifier.height(60.dp))

            Text(text = "Or continue with",
                color = Color(0xFF8F7D7D),
                letterSpacing = 2.sp,
                fontSize = 14.sp)

            Spacer(modifier = Modifier.height(15.dp))

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Login with Facebook",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp))

                Spacer(modifier = Modifier.width(30.dp))

                Icon(painter = painterResource(id = R.drawable.google),
                    contentDescription = "Login with Facebook",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp))
            }


        }

        TextRow(t1 = "Don't have an account? ",
            t2 = "Sign Up",
            t2Color = Color(0xFF5B67DB),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(20.dp).align(Alignment.BottomCenter)) {
            navController.navigate(NavScreen.SignUp.name)
        }

//        TextRow(t1 = "Don't have an account? ",
//            t2 = "Sing Up",
//            t2Color = Color(0xFF5B67DB),
//            fontSize = 15.sp,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 25.dp)) {
//
//        }


    }
}

@Composable
fun TextRow(
    modifier: Modifier = Modifier,
    t1: String,
    t1Color: Color = Color.Black,
    t2: String,
    t2Color: Color = Color.Black,
    fontSize: TextUnit,
    onClick: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Text(text = t1, color = t1Color, fontSize = fontSize)
        Text(text = t2,
            color = t2Color,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onClick() })
    }
}