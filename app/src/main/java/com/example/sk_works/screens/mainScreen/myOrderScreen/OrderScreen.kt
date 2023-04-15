package com.example.sk_works.screens.mainScreen.myOrderScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R
import com.example.sk_works.screens.component.MessageCard


enum class OrderTab {
    Ongoing,
    Completed
}

@Preview(showSystemUi = true)
@Composable
fun MyOrders() {

    var selectedTabIndex by remember {
        mutableStateOf(OrderTab.Ongoing.ordinal)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {

            Text(
                text = "My Orders",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )

        }

        TabRow(selectedTabIndex = selectedTabIndex,
            modifier = Modifier.height(60.dp),
            backgroundColor = Color.White,
            divider = {}
        ) {
            OrderTab.values().forEach { tab ->
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(15.dp))

            if (selectedTabIndex == OrderTab.Ongoing.ordinal) {

                ProductRow(completed = false, status = "Ongoing")

//                ItemRow2()
            } else {
                ProductRow()
            }
        }
    }
}


@Preview(name = "ProductRowCart")
@Composable
fun ProductRowCart(
    modifier: Modifier = Modifier,
    title: String = "Put title here",
    status: String = "Completed",
    Qty: String = "10",
    rating: String = "4.9",
    price: Int = 40000,
) {

    val Quantity = remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 5.dp)
            .height(140.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(15.dp))
            .background(color = Color.White)
            .then(modifier)

    ) {


        Row(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.39f)
                    .fillMaxHeight()
                    .padding(15.dp), elevation = 7.dp,
                shape = RoundedCornerShape(15.dp),
                color = Color.Yellow
            ) {

            }

            Spacer(modifier = Modifier.width(7.dp))

            Column(modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    modifier = Modifier.padding(end = 5.dp),
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    MessageCard(message = status)

                    Spacer(modifier = Modifier.width(8.dp))

                    Divider(
                        modifier = Modifier
                            .height(19.dp)
                            .width(1.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Qty: ${Qty}",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(id = R.drawable.star_t),
                        contentDescription = null,
                        modifier = Modifier
                            .size(17.dp)
                            .padding(start = 3.dp),
                        tint = Color(0xffFABC1D)
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Text(text = rating, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "₹${price}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )

            }
        }

        Surface(
            shape = CircleShape,
            modifier = Modifier
                .height(40.dp)
                .width(IntrinsicSize.Max)
                .padding(5.dp)
                .align(
                    Alignment.BottomEnd
                ),
            color = Color.LightGray.copy(alpha = 0.4f)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    tint = Color.Black.copy(alpha = 0.6f),
                    modifier = Modifier
                        .size(15.dp)
                        .clickable {
                            if (Quantity.value > 1) {
                                Quantity.value -= 1
                            }
                        })

                Spacer(modifier = Modifier.width(12.dp))

                Text(text = Quantity.value.toString(), fontSize = 19.sp, fontWeight = FontWeight.Black)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    tint = Color.Black.copy(alpha = 0.6f),
                    modifier = Modifier.clickable {
                        Quantity.value +=1
                    })
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

    }
}

@Preview(name = "Check")
@Composable
fun Check(modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .height(40.dp)
            .width(IntrinsicSize.Max)
            .padding(5.dp),
        color = Color.LightGray.copy(alpha = 0.4f)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = null,
                tint = Color.Black.copy(alpha = 0.6f),
                modifier = Modifier
                    .size(15.dp)
                    .clickable { })

            Spacer(modifier = Modifier.width(12.dp))

            Text(text = "1", fontSize = 19.sp, fontWeight = FontWeight.Black)

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = Color.Black.copy(alpha = 0.6f),
                modifier = Modifier.clickable { })
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}


@Preview(name = "ProductRow")
@Composable
fun ProductRow(
    modifier: Modifier = Modifier,
    title: String = "Boult Audio Powerbuds True Wireless in Ear Earbuds with 120H Playtime, in-Built Powerbank, Type-C Fast Charging, Made in India, Pro+ Calling HD Mic, IPX7 Waterproof, Bluetooth Ear Buds TWS (Black)",
    status: String = "Completed",
    Qty: String = "10",
    rating: String = "4.9",
    price: Int = 40000,
    trackReview: Boolean = false,
    completed: Boolean = true,
    onClick: () -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 5.dp)
            .wrapContentHeight()
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(15.dp))
            .background(color = Color.White)
            .then(modifier)

    ) {


        Row(modifier = Modifier
            .fillMaxSize()
            .height(IntrinsicSize.Max)) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.39f)
                    .fillMaxHeight()
                    .padding(10.dp), elevation = 7.dp,
                shape = RoundedCornerShape(15.dp),
                color = Color.Yellow
            ) {

            }

            Spacer(modifier = Modifier.width(2.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    modifier = Modifier.padding(end = 5.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    MessageCard(message = status)

                    Spacer(modifier = Modifier.width(8.dp))

                    Divider(
                        modifier = Modifier
                            .height(19.dp)
                            .width(1.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Qty: ${Qty}",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        painter = painterResource(id = R.drawable.star_t),
                        contentDescription = null,
                        modifier = Modifier
                            .size(17.dp)
                            .padding(start = 3.dp),
                        tint = Color(0xffFABC1D)
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Text(text = rating, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "₹${price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )
                
                Spacer(modifier = Modifier.height(10.dp))

            }
        }


        Spacer(modifier = Modifier.height(5.dp))

        if (!trackReview) {

            Button(
                onClick = { },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff000000)),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 5.dp, bottom = 4.dp)
            ) {
                if (completed) {
                    Text(text = "Write Review", fontWeight = FontWeight.Bold, color = Color.White)
                } else {
                    Text(text = "Track Order", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    }
}