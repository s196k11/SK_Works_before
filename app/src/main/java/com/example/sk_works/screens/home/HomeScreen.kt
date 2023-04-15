package com.example.sk_works.screens.home


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sk_works.R
import com.example.sk_works.navigation.navScreen.NavScreen
import com.example.sk_works.screens.component.HeightLightBannerCard
import com.example.sk_works.screens.component.ItemBox
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


//@Preview(showSystemUi = true)
//@Composable
//fun Home() {
//    val focusManager = LocalFocusManager.current
//
//
//
//    val text = remember { mutableStateOf("") }
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(color = Color(0xFFFFFFFF))
//        .padding(start = 3.dp, end = 3.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.height(5.dp))
//
//        TopAppBar(modifier = Modifier
//            .fillMaxWidth()
//            .height(70.dp),
//            elevation = 0.dp,
//            backgroundColor = Color(0xFFFFFFFF)
//        ) {
//
//            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
//
////                Icon(painter = painterResource(id = R.drawable.menu),
////                    contentDescription = null,
////                    modifier = Modifier.size(35.dp))
//
//                OutlinedTextField(value = text.value, onValueChange = {text.value = it},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(57.dp)
//                        .padding(horizontal = 5.dp),
//                    leadingIcon = {
//                        Icon(painter = painterResource(id = R.drawable.magnifying_glass),
//                            contentDescription = null,
//                            modifier = Modifier.size(35.dp))
//                    },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.LightGray,
//                        focusedBorderColor = Color.Gray),
//                    placeholder = { Text(text = "Search") },
//                    shape = RoundedCornerShape(19.dp),
//                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search, keyboardType = KeyboardType.Text),
//                    keyboardActions = KeyboardActions(onSearch = {
//                        focusManager.clearFocus(force = true)
//                    })
//                )
//            }
//        }
//
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())) {
//
//            ItemRow()
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text(text = "Recommended:", fontWeight = FontWeight.Bold, fontSize = 25.sp)
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Row(modifier = Modifier.horizontalScroll(rememberScrollState())){
//
//                ItemBox()
//                ItemBox()
//                ItemBox()
//                ItemBox()
//            }
//
//            //banner on this screen for customized orders
//        }
//    }
//}

//@Preview(showSystemUi = true)
@Composable
fun Home(navController: NavHostController) {
    val focusManager = LocalFocusManager.current

    val li = listOf<Int>(1,2,3,4,5,6,7,8,9,10)


    val text = remember { mutableStateOf("") }

    val l = listOf("https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg","https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg")

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(shape = RoundedCornerShape(bottomEnd = 9.dp, bottomStart = 9.dp)),
                elevation = 0.dp,
                backgroundColor = Color(0xFFF7EFEC),

                ) {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 8.dp),
                    textStyle = TextStyle(
                        fontSize =17.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal
                    ),
                    placeholder = { Text(text = "Search", fontSize = 17.sp) },
                    shape = RoundedCornerShape(10.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifying_glass),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(bottom = 65.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            BannerPager(count = l.size, ImageL = l)

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Trending",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {navController.navigate(NavScreen.ProductDetail.name) })
                }
            }

            TrendingBanner()

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "BestSeller",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {})
                }
            }

            TrendingBanner()

            HighlightedProduct()

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Customized",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {})
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "High Rated",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {})
                }
            }

            HighlightedProduct(heading = "Rust Free")

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Door",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {})
                }
            }

            TrendingBanner()

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Best Of All Time",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Text(text = "View All",color = Color.Blue,modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { })
            }

            LazyRow{
                items(li){
                    ItemBox(onClick = {})
                }
            }

            HighlightedProduct()

            Spacer(modifier = Modifier.height(15.dp))


            Divider(thickness = 2.dp, modifier = Modifier.padding(horizontal = 15.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { }, horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "See All Category", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Icon(painter = painterResource(id = R.drawable.arrow_right), contentDescription = null,modifier = Modifier.size(30.dp))
            }
            Divider(thickness = 2.dp, modifier = Modifier.padding(horizontal = 15.dp))

            Spacer(modifier = Modifier.height(15.dp))


        }
    }
}

//This for Eye catching thats why its name is highlightedProduct
@Composable
fun HighlightedProduct(heading:String = "New Arrivals"){
    val screenW = LocalConfiguration.current.screenWidthDp.dp

    Surface(modifier = Modifier.padding(2.dp),color = Color(0xFFD1CDFF),shape = RoundedCornerShape(10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = heading,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )

                Icon(painter = painterResource(id = R.drawable.next_arrow), contentDescription = null, modifier = Modifier.size(25.dp),tint = Color.Yellow)
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                HeightLightBannerCard()

                HeightLightBannerCard()
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                HeightLightBannerCard()

                HeightLightBannerCard()
            }

        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerPager(count:Int,ImageL:List<String>) {
    val pagerState = rememberPagerState()

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(horizontal = 15.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Surface(shape = RoundedCornerShape(9.dp),modifier = Modifier.wrapContentSize()) {
            HorizontalPager(count = count, state = pagerState) { page ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(color = Color(0xFFE9C8C8)), contentAlignment = Alignment.Center
                ) {
                    AsyncImage(model = ImageL[page], contentDescription = null, modifier =Modifier.fillMaxSize())
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row() {
            repeat(count) { iteration ->
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
}


@Composable
fun RatingBar(
    starSize:Int = 20,
    modifier: Modifier = Modifier,
    rating: Int,
) {
    val ratingState by remember {
        mutableStateOf(rating)
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.filled_star),
                contentDescription = "Star",
                modifier = Modifier
                    .size(starSize.dp)
                    .padding(2.dp),
                tint = if (i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
            )
        }
        Text(text = "(${rating})", fontSize = 20.sp, color = Color(0xFF807E7E))
    }
}


@Composable
fun RatingBarClickable(
    modifier: Modifier = Modifier,
    rating: Int,
) {
    var ratingState by remember {
        mutableStateOf(rating)
    }

    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..5) {
            Icon(painter = painterResource(id = R.drawable.filled_star),
                contentDescription = "Star",
                modifier = modifier
                    .width(34.dp)
                    .height(34.dp)
                    .clickable {
                        ratingState = i
                    }
                    .padding(2.dp),
                tint = if (i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
            )
        }
    }
}


@Composable
fun TrendingBanner() {
    //Implement paging here
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(7.dp)
            .clickable { },
        shape = RoundedCornerShape(10.dp),
        color = Color.Red
    ) {

    }
}

