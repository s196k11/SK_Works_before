package com.example.sk_works.screens.productDetailScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.component.ItemBox
import com.example.sk_works.screens.component.ShowRating_Solded
import com.example.sk_works.screens.home.RatingBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

sealed class DetailIcons(var desc: String, var icon: Int) {
    object Delivery : DetailIcons(desc = "Free\nDelivery", icon = R.drawable.free_delivery)
    object Quality : DetailIcons(desc = "Assured\nQuality", icon = R.drawable.quality)
    object Worker :
        DetailIcons(desc = "Professional\nWorker", icon = R.drawable.professional_worker)

    object Payment : DetailIcons(desc = "Secure\nPayment", icon = R.drawable.rupee)
}

@OptIn(ExperimentalPagerApi::class)
//@Preview(showSystemUi = false, heightDp = 2000, showBackground = true)
@Composable
fun ProductDetailScreen(navController: NavHostController) {
    val conf = LocalConfiguration.current
    val screenW = conf.screenWidthDp.dp
    val screenH = conf.screenHeightDp.dp
    val l = listOf(
        "https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg",
        "https://static.connect2india.com/c2icd/product_resources/images/fancy-stainless-steel-door.jpg"
    )
    val pagerState = rememberPagerState()
    val icons =
        listOf(DetailIcons.Delivery, DetailIcons.Quality, DetailIcons.Worker, DetailIcons.Payment)

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))

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

        Text(
            text = "Select Size :",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(start = 12.dp, top = 3.dp, end = 3.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        //LazyRow

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state = rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            SizeBox(width = "3", height = "6")
            Spacer(modifier = Modifier.width(8.dp))
            SizeBox(width = "4", height = "6")
            Spacer(modifier = Modifier.width(8.dp))
            SizeBox(width = "5", height = "8")
            Spacer(modifier = Modifier.width(8.dp))
            SizeBox(width = "40.5", height = "80.10")
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

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Don't worry while selecting size, we will visit site when you place order and take actual measurement.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0xFFDADADA))

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {navController.navigate(NavScreen.CustomizeProduct.name)},
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(horizontal = 12.dp, vertical = 5.dp),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFFFF8B13)),
            elevation = ButtonDefaults.elevation(8.dp),
            shape = RoundedCornerShape(7.dp)
        ) {
            Text(
                text = "Customize",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.shadow(elevation = 0.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "You can also customize your order according to you need.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color(0xFFDADADA))

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            //Add to cart button
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(screenW / 2)
                    .height(65.dp)
                    .padding(start = 12.dp, end = 5.dp)
                    .padding(vertical = 5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(
                        0xFFE93017
                    )
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.elevation(8.dp)
            ) {
                Text(text = "Add to Cart", color = Color.White, fontSize = 20.sp)
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
                    backgroundColor = Color(
                        0xFFE93017
                    )
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.elevation(8.dp)

            ) {
                Text(text = "Place Order", color = Color.White, fontSize = 20.sp)
            }
        }

        //request for visit button
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(horizontal = 12.dp, vertical = 5.dp),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF46CB25)),
            elevation = ButtonDefaults.elevation(8.dp),
            shape = RoundedCornerShape(7.dp)
        ) {
            Text(
                text = "Request for a visit",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.shadow(elevation = 0.dp)
            )
        }


        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 18.sp)) {
                append("Visiting Charge is ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append("₹500")
            }

            withStyle(style = SpanStyle(fontSize = 18.sp)) {
                append(" if you don’t place an order")
            }
        }, modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp))

        Spacer(modifier = Modifier.height(15.dp))

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFFDADADA))
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            icons.forEach { items ->
                ShowIcon(text = items.desc, id = items.icon)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFFDADADA))

        ProductDetailText()

        Spacer(modifier = Modifier.height(10.dp))

        RelatedProductRow()

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "See More",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(
                    Alignment.End
                )
                .padding(horizontal = 5.dp)
                .clickable { })

        Spacer(modifier = Modifier.height(10.dp))



        for (i in 1..5) {
            ProductDetailedImage(
                imageUrl = "https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg",
                Heading = "Dog ${i.toString()}"
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "You might also like",fontSize = 22.sp, letterSpacing = 1.sp, fontWeight = FontWeight.Black, modifier = Modifier.padding(start = 12.dp))

        LazyRow {
            items(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) { item ->
                ItemBox {
                    navController.navigate(NavScreen.ProductDetail.name)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Divider(thickness = 1.dp, color = Color.LightGray.copy(alpha = 0.4f))

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Customers Review",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )

            Text(
                text = "See more",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Blue,
                modifier = Modifier.padding(end = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))


        RatingCard()
    }

}

//show rating of products
@Composable
fun RatingCard() {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        Row(modifier = Modifier.padding(start = 10.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.fprofile),
                contentDescription = null,
                tint = Color.LightGray.copy(alpha = 0.7f),
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Kakashi Hatake", fontSize = 22.sp)
        }



        RatingBar(
            rating = 4, modifier = Modifier
                .padding(start = 10.dp)
                .padding(5.dp)
        )

        Text(
            text = "Awesome look",
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
        )


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), color = Color.Cyan.copy(alpha = 0.4f)
        ) {
        }


        Text(
            text = "Mirror shining look and perfect for main door with modern lock",
            fontSize = 19.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black.copy(alpha = 0.7f),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
        )

    }
}

@Composable
fun ShowIcon(text: String, id: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        FloatingActionButton(onClick = {}) {
            Icon(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier.size(if (text == "Free Delivery") 55.dp else 30.dp)
            )
        }

        Text(text = text, textAlign = TextAlign.Center)
    }
}


@Composable
fun DesignBox(url: String) {
    Surface(
        modifier = Modifier
            .size(75.dp)
            .padding(2.dp)
            .clickable { }, color = Color.Cyan, shape = RoundedCornerShape(6.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(), contentDescription = null, contentScale = ContentScale.Crop
        )
    }
}

//@Preview
@Composable
fun SizeBox(width: String, height: String, selected: Boolean = false) {
    Box(modifier = Modifier
        .wrapContentWidth()
        .height(40.dp)
        .border(
            border = BorderStroke(1.dp, color = Color.Black),
            shape = RoundedCornerShape(6.dp)
        )
        .background(
            color = if (selected) Color.Black else Color.White,
        )
        .padding(5.dp)
        .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${width}ft  X  ${height}ft",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Normal,
            color = if (selected) Color.White else Color.Black
        )
    }

}


@Composable
fun ProductDetailedImage(imageUrl: String, Heading: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 7.dp)
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = Heading, fontSize = 25.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            shape = RoundedCornerShape(7.dp),
            color = Color(0xFFff65ab)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(), contentDescription = null, contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

    }

}

@Composable
fun ProductDetailText() {

    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))

    val message =
        listOf(
            "4-pole jack is compatible for laptop which has only one audio male jack (input/output), iPhone android Smartphone, PlayStation 4, this mini microphone is specially designed for smartphone, tablet, laptop, PS4 or Skype, WhatsApp, FaceTime talking, YouTube recording, Podcasting, webinar",
            "The pin is thin enough to directly plug into your mobile 3.5mm headset jack even wearing a phone protector, High-quality and omnidirectional function, easy to use, Reception : High-quality Voice Technology",
            "An Extra 3-pin Adapter for DSLR: If you are going to use this mic with DSLR, camera or other device with 3-pin jack, please use this adapter."
        )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 4.dp)
    ) {
        Text(
            text = "Product Detail",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = Color.Black
        )


        message.forEach {
            Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Canvas(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .size(6.dp)
                ) {
                    drawCircle(Color.Black)
                }
                Text(text = it, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}


@Composable
fun RelatedProductRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Related Product",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp, modifier = Modifier.padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        val l = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        LazyRow {
            items(l) {
                Spacer(modifier = Modifier.width(12.dp))
                RelatedProduct()
//                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun RelatedProduct() {
    Column(modifier = Modifier
        .width(101.dp)
        .height(intrinsicSize = IntrinsicSize.Max)
        .clickable { }) {
        Surface(modifier = Modifier.size(101.dp), shape = RoundedCornerShape(8.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://i.pinimg.com/564x/a0/6d/27/a06d2778c07cb6b81ec7e9a77933db49.jpg")
                    .crossfade(true)
                    .build(), contentDescription = null, contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Steel Doors,302 Grade Premium Quality",
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Medium
        )
        Text(text = "₹5,000", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowRating(modifier: Modifier = Modifier,rating: Double = 4.0, totalRated: Int = 1500) {

    Row(verticalAlignment = Alignment.CenterVertically,modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.star_t),
            contentDescription = null,
            modifier = Modifier.size(18.dp).padding(horizontal = 3.dp),
            tint = Color.Unspecified
        )
        Text(text = rating.toString(), color = Color(0xff968D8D))
        Text(text = "(${totalRated.toString()})", color = Color(0xff968D8D))
    }
}

