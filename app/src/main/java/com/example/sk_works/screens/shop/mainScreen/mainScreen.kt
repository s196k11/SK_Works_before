package com.example.sk_works.screens.shop.mainScreen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R
import com.example.sk_works.screens.shop.dashboard.DashboardScreen
import com.example.sk_works.screens.shop.inventry.InventoryScreen

@Preview(showSystemUi = true)
@Composable
fun ShopMainScreen() {
    val focusManager = LocalFocusManager.current
    val t = rememberSaveable { mutableStateOf("") }

    val l = listOf<String>(
        "Dashboard",
        "Inventory",
        "Orders"
    )

    val clickedScreen = rememberSaveable { mutableStateOf("Dashboard") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF))
            .padding(start = 3.dp, end = 3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            elevation = 0.dp,
            backgroundColor = Color(0xFFFFFFFF)
        ) {

            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

                OutlinedTextField(
                    value = t.value, onValueChange = { t.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp)
                        .padding(horizontal = 5.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifying_glass),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Gray
                    ),
                    placeholder = { Text(text = "Search") },
                    shape = RoundedCornerShape(19.dp),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(onSearch = {
                        focusManager.clearFocus(force = true)
                    }),
                    textStyle = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                )
            }
        }
        
        Spacer(modifier = Modifier.height(5.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(l) { item ->

                Spacer(modifier = Modifier.width(10.dp))

                if (clickedScreen.value == item) {
                    ScreenBox(item, tColor = Color.White, backColor = Color.Black) {
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                } else {
                    ScreenBox(item, tColor = Color.Black, backColor = Color(0xffEAEAEA)) {
                        clickedScreen.value = item
                    }

                    Spacer(modifier = Modifier.width(10.dp))
                }

                Log.d("current: -> ", item)
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (clickedScreen.value == "Dashboard"){
            DashboardScreen()
        }else{
            if (clickedScreen.value == "Inventory"){
                InventoryScreen()
            }
        }

    }


}


@Composable
fun ScreenBox(text: String, tColor: Color, backColor: Color, onClick: () -> Unit = {}) {
    Surface(
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Max)
            .width(intrinsicSize = IntrinsicSize.Max)
            .clickable { onClick() },
        shape = CircleShape,
        color = backColor,
        contentColor = tColor,
        elevation = 9.dp
    ) {
        Text(
            text = text,
            color = tColor,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}


@Composable
fun DetailBox(title: String = "Total Orders", subtitle: String = "", onClick: () -> Unit = {}) {
    val screenW = LocalConfiguration.current.screenWidthDp.dp
    Surface(
        modifier = Modifier
            .width(screenW / 2)
            .height(105.dp)
            .padding(horizontal = 15.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(11.dp),
        color = Color(0xffEDEDED),
        elevation = 8.dp
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Text(
                text = subtitle,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DashboardPart(
    title1: String? = null, subtitle1: String? = null, onClick1: () -> Unit = {},
    title2: String? = null, subtitle2: String? = null, onClick2: () -> Unit = {},
    title3: String? = null, subtitle3: String? = null, onClick3: () -> Unit = {},
    title4: String? = null, subtitle4: String? = null, onClick4: () -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(modifier = Modifier.fillMaxHeight()) {

            if (title1 != null) {
                DetailBox(title = title1, subtitle = subtitle1!!) { onClick1() }
            }

            Spacer(modifier = Modifier.height(10.dp))


            if (title2 != null) {
                DetailBox(title = title2, subtitle = subtitle2!!) { onClick2() }

            }

        }


        Column(modifier = Modifier.fillMaxHeight()) {
            if (title3 != null) {
                DetailBox(title = title3, subtitle = subtitle3!!) { onClick3() }
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (title4 != null) {
                DetailBox(title = title4, subtitle = subtitle4!!) { onClick4() }
            }
        }
    }
}


@Composable
fun InventoryOption(text:String = "Edit Added \n Products", Icon:Int, onClick: () -> Unit = {}) {

    val screenW = LocalConfiguration.current.screenWidthDp.dp

    Surface(modifier = Modifier
        .height(60.dp)
        .width(screenW / 2)
        .padding(horizontal = 20.dp)
        .clickable { onClick() },
        color = Color(0xFFD9D9D9),
        shape = RoundedCornerShape(7.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,

            )

            Icon(painter = painterResource(id = Icon), contentDescription = null, modifier = Modifier.size(40.dp))

        }
    }
}




