package com.example.sk_works.screens.shop.addProducts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sk_works.screens.component.InputTextField
import com.example.sk_works.R

//@Preview(showSystemUi = true)
@Composable
fun AddProductDescription(viewModel: AddProductViewModel) {

    val value = rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                Icon(
                    painter = painterResource(id = com.example.sk_works.R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(start = 7.dp),
                    tint = Color.Black.copy(alpha = 0.7f)
                )
                Text(
                    text = "Add Product (Description)",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black.copy(alpha = 0.8f),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }, backgroundColor = Color(0xFFF7F7F7)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 8.dp)
        ) {

            InputTextField(
                text = "Description",
                value = value,
                placerHolder = "Description must be not more than 3 lines separated with \"!\".",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions.Default,
                singleLine = false
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Upload Featured Image:",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .padding(3.dp)
            )
            Text(
                text = "(With Title)",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .padding(3.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            FeaturedImageTitle()

            Icon(painter = painterResource(id = R.drawable.add), contentDescription = null,modifier = Modifier.size(65.dp).padding(start = 15.dp).padding(8.dp).align(Alignment.End).clickable {  })

            Text(text = viewModel.product.toString())
        }
    }
}


@Composable
fun FeaturedImageTitle() {

    val value = rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)) {
        OutlinedTextField(
            value = value.value,
            onValueChange = { value.value = it },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDBDBDB),
                unfocusedBorderColor = Color.Transparent,
                backgroundColor = Color(0xFFFEFEFE),
            ),
            placeholder = { Text(text = "Title") },
            maxLines = 3,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(onNext = {})
        )

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            modifier = Modifier
                .size(110.dp).clickable {  },
            shape = RoundedCornerShape(9.dp),
            elevation = 9.dp,
        ) {

            Icon(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = null,
                modifier = Modifier
                    .padding(30.dp)
                    )
        }



    }
}