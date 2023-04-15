package com.example.sk_works.screens.shop.addProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.component.CustomDropDownMenu
import com.example.sk_works.screens.component.Dummy
import com.example.sk_works.screens.component.InputTextField
import com.example.sk_works.screens.component.TakeMultiDesign

//@Preview(showSystemUi = false, heightDp = 2000)
@Composable
fun AddProductDesign(navController: NavController,viewModel: AddProductViewModel){

    val focusManager = LocalFocusManager.current

    val multiDesign = remember {mutableStateOf(true)}
    val value = rememberSaveable {mutableStateOf("")}


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(start = 7.dp),
                    tint = Color.Black.copy(alpha = 0.7f)
                )
                Text(
                    text = "Add Product (Design)",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black.copy(alpha = 0.8f),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }, backgroundColor = Color(0xFFF7F7F7)
    )
    { p ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(p)
                .padding(horizontal = 4.dp)
                .padding(5.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Multiple Design Available?",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Switch(
                checked = multiDesign.value,
                onCheckedChange = { multiDesign.value = !multiDesign.value },modifier = Modifier.padding(start = 8.dp))

            if (multiDesign.value){
                TakeMultiDesign(viewModel = viewModel)

//                Dummy(viewModel = viewModel)

                Icon(painter = painterResource(id = R.drawable.add), contentDescription = null,modifier = Modifier
                    .size(65.dp)
                    .padding(start = 15.dp)
                    .padding(8.dp)
                    .clickable { })
            }

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {
                    focusManager.clearFocus(force = true)
                    navController.navigate(NavScreen.AddProductDescription.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 5.dp),
                elevation = ButtonDefaults.elevation(8.dp),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Black)
            ) {
                Text(text = "Next", fontWeight = FontWeight.Bold,color = Color.White)
            }

            Spacer(modifier = Modifier.height(15.dp))
        }

    }
}