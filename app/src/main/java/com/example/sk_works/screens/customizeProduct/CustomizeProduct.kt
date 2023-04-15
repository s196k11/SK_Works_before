package com.example.sk_works.screens.customizeProduct

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.component.ItemBox
import com.example.sk_works.screens.home.RatingBar
import com.example.sk_works.screens.productDetailScreen.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomizeProduct(productMaterial: String = "steel",navController: NavController) {
    val conf = LocalConfiguration.current
    val screenW = conf.screenWidthDp.dp
    val screenH = conf.screenHeightDp.dp
    val l = listOf(
        "https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg",
        "https://static.connect2india.com/c2icd/product_resources/images/fancy-stainless-steel-door.jpg"
    )
    val pagerState = rememberPagerState()

    val demoText = remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val paintAvailable = remember { mutableStateOf(true) }
    val lockAvailable = remember { mutableStateOf(true) }
    val mosquitoShieldAvailable = remember { mutableStateOf(true) }
    val customeDesignImage = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
//            .padding(start = 4.dp, end = 4.dp)
            .verticalScroll(rememberScrollState())
    ) {

//                androidx.compose.material.Surface(modifier = Modifier
//                    .fillMaxWidth()
//                    .height(300.dp),
//                    shape = RoundedCornerShape(6.dp),
//                    color = Color.Red
//                ) {
//
//                }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenH / 2 + 20.dp)
            ) {


                HorizontalPager(count = 2, state = pagerState) { page ->
                    AsyncImage(
                        model = l[page],
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                FloatingActionButton(
                    onClick = {},
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    backgroundColor = Color.Transparent,
                    modifier = Modifier.align(
                        Alignment.TopStart
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )

                }

                FloatingActionButton(
                    onClick = { },
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    backgroundColor = Color.Transparent,
                    modifier = Modifier.align(
                        Alignment.BottomEnd
                    )
                ) {

                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )

                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                repeat(2) { iteration ->
                    var color = if (pagerState.currentPage == iteration) {
                        Color.DarkGray
                    } else Color.LightGray

                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(color = color)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))





        Text(
            text = "Red Tape Men's Walking Shoes",
            fontSize = 28.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 12.dp)
        )

        ShowRating(modifier = Modifier.padding(start = 12.dp))



        Text(
            text = "$4000",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp,
            color = Color(0xFF042390),
            modifier = Modifier.padding(start = 12.dp)
        )



        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "This shoes are made up of synthetic leather with rubber sole.",
            fontSize = 16.sp,
            color = Color(0xFF434242),
//            maxLines = 2,
//            overflow = TextOverflow.Ellipsis,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(start = 12.dp, end = 3.dp, top = 3.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0xFFDADADA))

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Select Design :",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        //LazyRow
        LazyRow {


            items(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) { item ->
                Spacer(modifier = Modifier.width(12.dp))
                DesignBox(url = "")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Enter Size :",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Length :",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        OutlinedTextField(
            value = demoText.value,
            onValueChange = { demoText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xFFF7F7F7),
                focusedBorderColor = Color.Black.copy(alpha = 0.6f),
                unfocusedBorderColor = Color.Gray
            ),
            placeholder = { Text(text = "Enter Length in feet") },
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Width :",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        OutlinedTextField(
            value = demoText.value,
            onValueChange = { demoText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xFFF7F7F7),
                focusedBorderColor = Color.Black.copy(alpha = 0.6f),
                unfocusedBorderColor = Color.Gray
            ),
            placeholder = { Text(text = "Enter Width in feet") },
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Height :",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        OutlinedTextField(
            value = demoText.value,
            onValueChange = { demoText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xFFF7F7F7),
                focusedBorderColor = Color.Black.copy(alpha = 0.6f),
                unfocusedBorderColor = Color.Gray
            ),
            placeholder = { Text(text = "Enter height in feet (if have)") },
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus(force = true) })
        )

        Spacer(modifier = Modifier.height(15.dp))

        if (productMaterial == "steel") {
            Text(
                text = "Steel Grade :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            val l = listOf(202, 304, 405)
            var selec = remember { mutableStateOf(l[0]) }

            LazyRow {
                items(l) { item ->

                    Spacer(modifier = Modifier.width(10.dp))
                    ShowCard(text = item.toString(), selected = selec.value.toString()) {
                        selec.value = item
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (paintAvailable.value) {
            Text(
                text = "Paint Colors :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))


            val l = listOf("Truck Brown", "Brown")
            var selec = remember { mutableStateOf(l[0]) }

            LazyRow {
                items(l) { item ->
                    Spacer(modifier = Modifier.width(10.dp))
                    ShowCard(text = item.toString(), selected = selec.value.toString()) {
                        selec.value = item
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (lockAvailable.value) {
            Text(
                text = "Lock Types :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))


            val l = listOf("Standard", "Semi Auto")
            var selec = remember { mutableStateOf(l[0]) }

            LazyRow {
                items(l) { item ->
                    Spacer(modifier = Modifier.width(10.dp))
                    ShowCard(text = item.toString(), selected = selec.value.toString()) {
                        selec.value = item
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (mosquitoShieldAvailable.value) {
            Text(
                text = "Mosquito Shield :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(0.dp))

            val va = remember { mutableStateOf(false) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = va.value,
                    onCheckedChange = { va.value = it },
                    modifier = Modifier.padding(start = 20.dp)
                )

                if (va.value) {
                    Text(
                        text = "Yes",
                        modifier = Modifier.padding(start = 5.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                } else {
                    Text(
                        text = "No",
                        modifier = Modifier.padding(start = 5.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Text(
            text = "Extend Warranty :",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        val l = listOf("6 Months", "1 Year", "2 Year")
        var selec = remember { mutableStateOf(l[0]) }

        LazyRow {
            items(l) { item ->
                Spacer(modifier = Modifier.width(10.dp))
                ShowCard(text = item.toString(), selected = selec.value.toString()) {
                    selec.value = item
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Want to Add Different Design? :",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 12.dp)
        )

        Switch(checked = customeDesignImage.value, onCheckedChange = {customeDesignImage.value = it},modifier = Modifier.padding(start = 20.dp))



        Spacer(modifier = Modifier.height(15.dp))

        if (customeDesignImage.value) {
            Text(
                text = "Add Your Design Images :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Icon(painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 15.dp)
                    .clickable { })
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Enter Additional Features you want :",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 12.dp),
            shape = RoundedCornerShape(6.dp),
            placeholder = {Text(text = "Write your requirements and features what you want in your order here.")}
        )


        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            //Add to cart button
            OutlinedButton(
                onClick = { navController.navigate(NavScreen.PlaceOrderScreen.name) },
                modifier = Modifier
                    .width(screenW / 2)
                    .height(65.dp)
                    .padding(start = 12.dp, end = 5.dp)
                    .padding(vertical = 5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xFF1C2125),
                ),
                shape = RoundedCornerShape(8.dp),
//                elevation = ButtonDefaults.elevation(8.dp),
            ) {
                Text(text = "Place Order", color = Color.White, fontSize = 20.sp)
            }

            //place order button
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(screenW / 2)
                    .height(65.dp)
                    .padding(end = 12.dp, start = 5.dp)
                    .padding(vertical = 5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xFF363F46)
                ),
                shape = RoundedCornerShape(8.dp),
//                elevation = ButtonDefaults.elevation(8.dp)

            ) {
                Text(text = "Get Price", color = Color.White, fontSize = 20.sp)
            }
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(horizontal = 12.dp, vertical = 5.dp),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF5B67DB)),
//            elevation = ButtonDefaults.elevation(8.dp),
            shape = RoundedCornerShape(7.dp)
        ) {
            Text(
                text = "Talk with Expert",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.shadow(elevation = 0.dp)
            )
        }

    }
}


//This is used for show the grade of steel like 202, 304 etc..
@Composable
fun ShowCard(text: String, selected: String, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(40.dp)
            .border(
                border = BorderStroke(1.dp, color = Color.Black),
                shape = RoundedCornerShape(6.dp)
            )
            .background(
                color = if (text == selected.toString()) Color.Black else Color.White,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(5.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 30.dp, vertical = 0.dp),
            color = if (text == selected.toString()) Color.White else Color.Black
        )
    }
}