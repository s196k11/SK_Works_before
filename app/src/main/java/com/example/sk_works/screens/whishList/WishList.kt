package com.example.sk_works.screens.whishList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.screens.home.RatingBar


@Preview(showSystemUi = true)
@Composable
fun Wishlist() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(modifier = Modifier.fillMaxWidth(),
            elevation = 0.dp,
            backgroundColor = Color.Transparent) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {

                Text(text = "Wishlist",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                    color = Color.Black)
            }
        }

        WishlistRow()
    }
}


@Composable
fun WishlistRow() {
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        color = Color.White
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.35f)
                .background(color = Color.Red)
            ) {
            }

            Spacer(modifier = Modifier.width(7.dp))

            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()) {
                    Text(
                        text = "Steel Door",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        maxLines = 1,
                    )

                    Text(text = "by SK works",
                        color = Color(0xFF968D8D),
                        fontSize = 12.sp,
                        letterSpacing = 1.sp)

                    Text(text = "₹" + "50,000",
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF5B67DB),
                        fontSize = 16.sp,
                        letterSpacing = 1.sp,
                        modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
                    )

                    Text(text = "Get it in a week", color = Color(0xFF968D8D))

                    RatingBar(rating = 0, modifier = Modifier.padding(top = 4.dp))
                }

//                OutlinedButton(onClick = {}, modifier = Modifier
//                    .height(35.dp)
//                    .width(105.dp)
//                    .align(Alignment.CenterEnd),
//                    shape = CutCornerShape(topEnd = 17.dp, bottomEnd = 17.dp),
//                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFFFABC1D))
//                ) {
//                    Text(text = "Customize >")
//                }

                Icon(imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopEnd).size(45.dp).padding(5.dp),tint = Color.Red)
            }
        }
    }
}