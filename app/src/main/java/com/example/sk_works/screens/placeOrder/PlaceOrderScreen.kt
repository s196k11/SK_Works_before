package com.example.sk_works.screens.placeOrder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R


@Preview(showSystemUi = true)
@Composable
fun PlaceOrderScreen() {
    //Current State of order
    val review = rememberSaveable { mutableStateOf(true) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray.copy(alpha = 0.4f))
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp), elevation = 0.dp
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text(text = "Cancel", modifier = Modifier.padding(5.dp))
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(bottom = 15.dp, top = 15.dp)
            ) {
                CircleWithText(text = "1", desc = "Review", circleSize = 15)

                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.LightGray.copy(alpha = 0.4f), modifier = Modifier
                        .width(80.dp)
                        .padding(bottom = 20.dp)
                )

                CircleWithText(text = "2", desc = "Payment", circleSize = 15)

            }



            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray.copy(alpha = 0.4f),
                thickness = 2.dp
            )

            ItemCard(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))

            DeliveryTime(modifier = Modifier.padding(vertical = 5.dp, horizontal = 7.dp))

            DeliveryAddressCard(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
        }
    }
}

@Composable
fun CircleWithText(text: String, desc: String, circleSize: Int = 10, color: Color = Color.Gray) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .border(border = BorderStroke(width = 1.dp, color = color), shape = CircleShape)
                .size(circleSize.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, fontSize = 10.sp, color = color)
        }

        Text(text = desc, fontSize = 14.sp, color = color)
    }
}


//To show Items in place order screen
@Composable
fun ItemCard(modifier: Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        shape = RoundedCornerShape(9.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .height(100.dp)
                    .padding(start = 10.dp, end = 10.dp), color = Color.Yellow
            ) {
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column() {
                Text(
                    text = "Steel Door With 304 Grade Steel Made up of bla bla bla",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Text(
                    text = "3,000",
                    fontSize = 17.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "Size: ${"Free Size"}", color = Color.DarkGray, fontSize = 15.sp)

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "Qty: ${"1"}", fontSize = 15.sp, color = Color.DarkGray)
            }
        }
    }
}

//to show estimate delivery time
@Composable
fun DeliveryTime(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .then(modifier)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.delivery_van),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 15.dp),
                tint = Color.DarkGray.copy(alpha = 0.7f)
            )
            Text(
                text = "Estimated Delivery within 7 working days.",
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}


@Composable
fun DeliveryAddressCard(modifier:Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        shape = RoundedCornerShape(9.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Delivery Address", fontWeight = FontWeight.SemiBold, color = Color.Black, fontSize = 20.sp)

            OutlinedButton(onClick = { /*TODO*/ }, border = BorderStroke(width = 1.dp,color = Color.Black), colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.White)) {
                Text(text = "Change", color = Color.Black)
            }
        }
    }
}