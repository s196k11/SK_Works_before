package com.example.sk_works.screens.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.screens.home.RatingBar
import com.example.sk_works.screens.mainScreen.myOrderScreen.ProductRowCart


enum class CartTab {
    CART,
    WISHLIST
}

@Preview(showSystemUi = true)
@Composable
fun Cart() {

//    Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFFD9D9D9))) {
//
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 5.dp),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            TopAppBar(modifier = Modifier.fillMaxWidth(),
//                backgroundColor = Color(0xFFFFFFFF),
//                elevation = 0.dp) {
//                Row(modifier = Modifier.fillMaxSize(),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(imageVector = Icons.Default.ArrowBack,
//                        contentDescription = null,
//                        modifier = Modifier.size(35.dp))
//
//                    Icon(imageVector = Icons.Default.FavoriteBorder,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(35.dp)
//                            .padding(3.dp))
//                }
//            }
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Column(modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())) {
//
//                CartItemRow()
//            }
//
//        }
//
//
//    }


    var selectedTabIndex by remember {
        mutableStateOf(CartTab.CART.ordinal)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.White, elevation = 0.dp) {

            Text(text = "My Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(start = 10.dp))

        }

        TabRow(selectedTabIndex = selectedTabIndex,
            modifier = Modifier.height(60.dp),
            backgroundColor = Color.White,
            divider = {}
        ) {
            CartTab.values().forEach { tab ->
                Tab(
                    selected = selectedTabIndex == tab.ordinal,
                    onClick = { selectedTabIndex = tab.ordinal },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color(0xFF7A7A7A)
                ) {

                    Text(text = tab.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ){

            Spacer(modifier = Modifier.height(15.dp))

            if (selectedTabIndex == CartTab.CART.ordinal){
                ProductRowCart()
            }else{
                Text(text = "There is No items in Wishlist")
            }
        }
    }
}

@Composable
fun CartItemRow() {
    val localConf = LocalConfiguration.current
    val screenW = localConf.screenWidthDp.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(8.dp), elevation = 8.dp
    ) {

        Column(modifier = Modifier.fillMaxSize()) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .width(screenW / 3 + 10.dp)
                        .height(140.dp), color = Color.Cyan
                ) {

                }

                Spacer(modifier = Modifier.width(7.dp))

                Column(modifier = Modifier.fillMaxSize()) {

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Steel Door, Grade 304, size 4x7",
                        fontSize = 20.sp,
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(end = 5.dp)
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Small Desc",
                        fontSize = 17.sp,
                        color = Color(0xFF817D7D),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    RatingBar(rating = 4)

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "₹40,000",
                        color = Color.Red,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(text = "Deliver with a week")
                }
            }

            Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray, thickness = 2.dp)

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = "Remove",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable { })

                Divider(
                    color = Color.Gray, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                )

                Text(
                    text = "Quantity",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {})

                Divider(
                    color = Color.Gray, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                )

                Text(
                    text = "Place Order",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {})


            }
        }

    }
}