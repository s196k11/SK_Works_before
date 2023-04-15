package com.example.sk_works.screens.shop.addProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.screens.productDetailScreen.*
import com.example.sk_works.screens.productDetailScreen.*

@Composable
fun AddProductPreview(viewModel: AddProductViewModel){

    val conf = LocalConfiguration.current
    val screenW = conf.screenWidthDp.dp



    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
//            TopAppBar(modifier = Modifier.fillMaxWidth(),
//                backgroundColor = Color.Transparent,
//                elevation = 0.dp) {
//                Row(modifier = Modifier.fillMaxSize(),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(imageVector = Icons.Default.ArrowBack,
//                        contentDescription = null,
//                        modifier = Modifier.size(35.dp))
//
//                }
//            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .padding(start = 4.dp, end = 4.dp)
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

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(9.dp))) {

                    FloatingActionButton(onClick = {}, elevation = FloatingActionButtonDefaults.elevation(0.dp),backgroundColor = Color.Transparent,modifier = Modifier.align(
                        Alignment.TopStart)) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp))

                    }

                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Steel Door",
                        fontSize = 28.sp,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp))

                }

                ShowRating()


                Text(text = "₹40,000",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF042390),
                    modifier = Modifier.padding(start = 4.dp))



                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "This door is made of 304 grade steel and its width is 4 feet height is 9 feet and This door is made of 304 grade steel and its width is 4 feet height is 9 feet",
                    fontSize = 16.sp,
                    color = Color(0xFF434242),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(start = 3.dp, end = 3.dp, top = 3.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Select Design :",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(start = 3.dp, top = 3.dp, end = 3.dp))

                Spacer(modifier = Modifier.height(10.dp))

                //LazyRow
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(
                        rememberScrollState()
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DesignBox(url = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    DesignBox(url = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg")
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Select Size :",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(start = 3.dp, top = 3.dp, end = 3.dp))

                Spacer(modifier = Modifier.height(10.dp))

                //LazyRow

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state = rememberScrollState())) {
                    SizeBox(width = "3", height = "6")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "4", height = "6")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "5", height = "8")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    SizeBox(width = "", height = "")
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    OutlinedButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(screenW / 2)
                            .height(65.dp)
                            .padding(5.dp),
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(
                            0xFFE93017)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.elevation(8.dp)
                    ) {
                        Text(text = "Add to Cart", color = Color.White, fontSize = 20.sp)
                    }

                    OutlinedButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(screenW / 2)
                            .height(65.dp)
                            .padding(5.dp),
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(
                            0xFFE93017)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.elevation(8.dp)

                    ) {
                        Text(text = "Place Order", color = Color.White, fontSize = 20.sp)
                    }
                }

                OutlinedButton(onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(68.dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF46CB25)),
                    elevation = ButtonDefaults.elevation(8.dp),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(text = "Request for a visit",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.shadow(elevation = 0.dp))
                }


                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 18.sp)) {
                        append("Visiting Charge is ")
                    }

                    withStyle(style = SpanStyle(color = Color.Red,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                    ) {
                        append("₹500")
                    }

                    withStyle(style = SpanStyle(fontSize = 18.sp)) {
                        append(" if you don’t place an order")
                    }
                }, modifier = Modifier.padding(5.dp))

                Spacer(modifier = Modifier.height(15.dp))

//                Text(text = "Product Detail :", fontWeight = FontWeight.Bold, fontSize = 25.sp)
//
//                Text(text = "jfasklfj\nfsdfa\njfasklfj\njfasklfj\n")

                ProductDetailText()

                RelatedProductRow()

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "See More",color = Color.Blue, fontWeight = FontWeight.SemiBold,modifier = Modifier
                    .align(
                        Alignment.End
                    )
                    .padding(horizontal = 5.dp)
                    .clickable { })

                Spacer(modifier = Modifier.height(10.dp))



                for (i in 1..5){
                    ProductDetailedImage(imageUrl = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg", Heading = "Dog ${i.toString()}")
                }
            }
        }
    }
}