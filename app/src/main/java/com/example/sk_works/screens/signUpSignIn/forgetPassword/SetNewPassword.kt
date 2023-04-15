package com.example.sk_works.screens.signUpSignIn.forgetPassword

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sk_works.navigation.navScreen.NavScreen


//@Preview(showSystemUi = true)
@Composable
fun SetNewPassword(navController: NavController) {

    val focusManager = LocalFocusManager.current


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFEEE8E7))) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(7.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back to Login",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
                    .size(35.dp)
                    .clickable { navController.popBackStack()}
            )

            Box(modifier = Modifier.size(150.dp).background(color = Color(0xFFEEE8E7))){
                Text(text = "Select Image for here",modifier = Modifier.align(Alignment.Center))
            }


            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Set New Password",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp)
//            Text(text = "",
//                fontSize = 15.sp,
//                letterSpacing = 3.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = Color(0xFF8F7D7D))

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
                placeholder = { Text(text = "New Password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = "Enter new password")
                },
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) })
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .shadow(elevation = 3.dp, shape = CircleShape),
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF5B67DB)
                ),
                placeholder = { Text(text = "Confirm Password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = "Enter confirmed password")
                },
                trailingIcon = {},
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus(force = true)
                })
            )


            Spacer(modifier = Modifier.height(25.dp))

            Button(onClick = { navController.navigate(NavScreen.SignIn.name) }, modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .shadow(elevation = 7.dp, shape = CircleShape),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF5B67DB)),
                shape = CircleShape
            ) {
                Text(text = "Reset Password",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp)
            }
        }
    }
}