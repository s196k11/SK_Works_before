package com.example.sk_works.screens.mainScreen.myOrderScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R

//Status codes
//1 = order placed
//2 = order verified
//3 = order underProcess
//4 = order out for delivery
//5 = order delivered
//special code is for backup or for use in some kind of problem

@Preview(showSystemUi = true)
@Composable
fun TrackOrderScreen(orderStatusCode:Int = 3,specialCode:String? = null){

    val d = mapOf<Int,Int>(R.drawable.order_placed to 1, R.drawable.order_verified to 2, R.drawable.order_underprocess to 3, R.drawable.delivery_van to 4, R.drawable.order_delivered to 5)
    val statusMeaning = mapOf<Int,String>(1 to "Order Placed Successfully",2 to "Order Verified", 3 to "Order Under Process", 4 to "Order Out For Delivery", 5 to "Order Delivered Successfully")
    Scaffold(
        topBar = { TopAppBar(backgroundColor = Color.White, elevation = 0.dp) {

            Row(modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Track Order",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    color = Color.Black.copy(alpha = 0.8f)
                )

            }
        }
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProductRow(trackReview = true)

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .height(intrinsicSize = IntrinsicSize.Max), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){


                for (i in d){

                    if (i.value <= orderStatusCode){



                        if (i.value == 5){
                            Icon(painter = painterResource(id = i.key), contentDescription = null, modifier = Modifier.size(50.dp), tint = Color.Black)
                        }else {
                            Icon(
                                painter = painterResource(id = i.key),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                tint = Color.Black
                            )

                            Divider(modifier = Modifier.width(20.dp), thickness = 4.dp)

                        }
                    }else{
                        if (i.value == 5){
                            Icon(painter = painterResource(id = i.key), contentDescription = null, modifier = Modifier.size(50.dp), tint = Color.DarkGray)
                        }else {
                            Icon(
                                painter = painterResource(id = i.key),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                tint = Color.DarkGray
                            )

                            Divider(modifier = Modifier.width(30.dp), thickness = 4.dp)

                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            if (specialCode != null){
                Text(text = specialCode, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            }else {
                for (c in statusMeaning) {
                    if (orderStatusCode == c.key) {
                        Text(
                            text = c.value,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp))
        }
    }
}