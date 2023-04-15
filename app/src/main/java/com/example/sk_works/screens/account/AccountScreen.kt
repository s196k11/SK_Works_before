package com.example.sk_works.screens.account


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R

@Preview(showSystemUi = true)
@Composable
fun Account() {


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(modifier = Modifier.fillMaxWidth(),
                elevation = 0.dp,
                backgroundColor = Color(0xFFFFFFFF)
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Icon(painter = painterResource(id = R.drawable.left), contentDescription = null,modifier = Modifier
                        .size(42.dp)
                        .padding(4.dp)
                        .clickable { })
                    Text(text = "XYZ", fontWeight = FontWeight.Bold, fontSize = 20.sp,modifier = Modifier.padding(5.dp))
                    Icon(painter = painterResource(id = R.drawable.setting), contentDescription = null,modifier = Modifier
                        .size(42.dp)
                        .padding(4.dp)
                        .clickable { })
                }
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(modifier = Modifier.size(150.dp)) {

                    Image(
                        painter = painterResource(id = R.drawable.user_b),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = CircleShape)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_square_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .align(
                                Alignment.BottomEnd
                            )
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(7.dp))
                            .padding(bottom = 4.dp, end = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(text = "XYZ Kumar", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "block-A Rajapuri gali no-10 uttam nagar new delhi-110059",
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color(0xFF8B8B8B), textAlign = TextAlign.Center,modifier = Modifier.padding(5.dp))

                val l = listOf("Edit Profile","Your Orders","Your Address","Security","Cart","Wishlist","Settings","Contact Us")


                RButton(icon = R.drawable.user_s, text = "Edit Profile")
                RButton(icon = R.drawable.big_box, text = "Your Orders")
                RButton(icon = R.drawable.address, text = "Your Address")
                RButton(icon = R.drawable.shopping_cart, text = "Cart")
                RButton(icon = R.drawable.heart, text = "Wishlist")
                RButton(icon = R.drawable.setting, text = "Settings")
                RButton(icon = R.drawable.information, text = "Help")
                RButton(icon = R.drawable.invite, text = "Invite People")

                Spacer(modifier = Modifier.height(60.dp))


            }
        }
    }
}


@Composable
fun RButton(modifier: Modifier = Modifier,icon:Int,text:String){
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp

    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {



            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 15.dp)) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    text = text,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

            Icon(painter = painterResource(id = R.drawable.next), contentDescription = null,modifier = Modifier
                .size(44.dp)
                .padding(5.dp))
        }
    }
}