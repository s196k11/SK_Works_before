package com.example.sk_works.screens.review

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.R
import com.example.sk_works.screens.home.RatingBarClickable
import com.example.sk_works.screens.mainScreen.myOrderScreen.ProductRow

@Preview(showSystemUi = true)
@Composable
fun ReviewScreen() {

    val screenW = LocalConfiguration.current.screenWidthDp.dp


    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White, elevation = 0.dp) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black.copy(alpha = 0.8f)
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        text = "Review",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        color = Color.Black.copy(alpha = 0.8f)
                    )

                }

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProductRow(trackReview = true)

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "How is you order?", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Text(text = "give us rating & also write reviews", color = Color.Gray)

            Spacer(modifier = Modifier.height(20.dp))

            //Use ViewModel to capture rating
            RatingBarClickable(rating = 0)

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp),
                placeholder = { Text(text = "Write review here", fontWeight = FontWeight.Bold) },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(onDone = {}),

                )

            Spacer(modifier = Modifier.height(50.dp))

            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly){
                Button(
                    onClick = { },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffCDCDCD)),
                    modifier = Modifier.width(screenW/3).height(45.dp)

                ) {
                    Text(text = "Cancel", fontWeight = FontWeight.Bold, color = Color(0xff353535))
                }

                Button(
                    onClick = { },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff000000)),
                    modifier = Modifier.width(screenW/3).height(45.dp)

                ) {
                    Text(text = "Submit", fontWeight = FontWeight.Bold, color = Color.White)

                }
            }
        }
    }

}