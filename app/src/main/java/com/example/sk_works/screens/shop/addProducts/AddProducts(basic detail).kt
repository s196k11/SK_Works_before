package com.example.sk_works.screens.shop.addProducts

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.component.CustomDropDownMenu
import com.example.sk_works.screens.component.InputTextField


//@Preview(showSystemUi = true)
@Composable
fun AddProduct_basicD(navController: NavController, viewModel: AddProductViewModel) {

    //Some of these below are only for demo purpose
    val focusManager = LocalFocusManager.current
    val colorName = remember {mutableStateOf("")}
    val productName = remember { mutableStateOf("") }
    val smallDesc = remember { mutableStateOf("") }
    val expectedDeliveryDays = remember { mutableStateOf("") }
    val installationCharge = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }
    val demoCategory = listOf<String>(
        "Door",
        "Window",
        "Railing",
        "Shed",
        "Stand",
        "Table",
        "Shutter",
    )

    val demoMaterialUsed = listOf<String>("Iron", "Steel", "Alumunium", "GI Sheet", "Wooden")

    val selectedCategory = remember { mutableStateOf("") }
    val selectedMaterialUsed = remember { mutableStateOf("") }
    val customization = remember { mutableStateOf(true) }
    val installation = remember { mutableStateOf(true) }
    val mosquitoShieldAvailable = remember {mutableStateOf(true)}


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
                        .size(30.dp)
                        .padding(start = 7.dp),
                    tint = Color.Black
                )
                Text(
                    text = "Add Product (Basic Detail)",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
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
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {


            Spacer(modifier = Modifier.height(20.dp))

            InputTextField(
                text = "Product Name/Title",
                value = productName,
                placerHolder = "eg: Headphones",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) })
            )

            Spacer(modifier = Modifier.height(15.dp))

            InputTextField(
                text = "Small Description",
                value = smallDesc,
                placerHolder = "eg: This is the water proof headphone",
                maxLines = 4,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) })
            )

            Spacer(modifier = Modifier.height(15.dp))

            CustomDropDownMenu(
                text = "Category",
                selected = selectedCategory,
                menuItem = demoCategory
            )

            Spacer(modifier = Modifier.height(15.dp))

            CustomDropDownMenu(
                text = "Material Used",
                selected = selectedMaterialUsed,
                menuItem = demoMaterialUsed
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Customization Available?",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Switch(
                checked = customization.value,
                onCheckedChange = { customization.value = !customization.value })

            if (customization.value) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                ) {

                    Column(modifier = Modifier.fillMaxWidth().padding(start = 30.dp)) {

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Custom Size Available?",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Switch(
                            checked = customization.value,
                            onCheckedChange = { customization.value = !customization.value })

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Custom Design Available?",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Switch(
                            checked = customization.value,
                            onCheckedChange = { customization.value = !customization.value })

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Custom Paint Available?",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Switch(
                            checked = customization.value,
                            onCheckedChange = { customization.value = !customization.value })


                        Spacer(modifier = Modifier.height(15.dp))
                    }

                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            InputTextField(
                text = "Expected Days to Complete work with delivery?",
                value = expectedDeliveryDays,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) }),
                placerHolder = "eg: 8 (In day)"
            )

            Spacer(modifier = Modifier.height(15.dp))

            if (selectedCategory.value.lowercase() == "door"){
                Text(
                    text = "Mosquito Shield Available?",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Switch(
                    checked = mosquitoShieldAvailable.value,
                    onCheckedChange = { mosquitoShieldAvailable.value = !mosquitoShieldAvailable.value })
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Installation Available?",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Switch(
                checked = installation.value,
                onCheckedChange = { installation.value = !installation.value })

            Spacer(modifier = Modifier.height(8.dp))

            if (installation.value) {
                InputTextField(
                    text = "Installation charges",
                    value = installationCharge,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus(force = true) }),
                    placerHolder = "eg: 5000"
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedButton(
                onClick = {
                    focusManager.clearFocus(force = true)
                    navController.navigate(NavScreen.AddProductDesign.name)
                    viewModel.product["productName"] = productName.value
                    viewModel.product["smallDesc"] = smallDesc.value
                    viewModel.product["category"] = selectedCategory.value
                    viewModel.product["materialUsed"] = selectedMaterialUsed.value
                    viewModel.product["customizationAV?"] = customization.value
                    viewModel.product["expectedDaysOfDelivery"] = expectedDeliveryDays.value
                    viewModel.product["installationAV?"] = installation.value
                    viewModel.product["installationCharge"] = installationCharge.value


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 5.dp),
                elevation = ButtonDefaults.elevation(8.dp),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Black)
            ) {
                Text(text = "Next", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(15.dp))

        }
    }
}

