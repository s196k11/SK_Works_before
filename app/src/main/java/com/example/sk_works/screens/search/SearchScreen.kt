package com.example.sk_works.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.sk_works.R
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchScreen(){

    val focusManager = LocalFocusManager.current
    val t = rememberSaveable { mutableStateOf("") }



    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF))
        .padding(start = 3.dp, end = 3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
            elevation = 0.dp,
            backgroundColor = Color(0xFFFFFFFF)
        ) {

            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

//                Icon(painter = painterResource(id = R.drawable.menu),
//                    contentDescription = null,
//                    modifier = Modifier.size(35.dp))

                OutlinedTextField(value = t.value, onValueChange = {t.value = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp)
                        .padding(horizontal = 5.dp),
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.magnifying_glass),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = Color.Gray),
                    placeholder = { Text(text = "Search") },
                    shape = RoundedCornerShape(19.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search, keyboardType = KeyboardType.Text),
                    keyboardActions = KeyboardActions(onSearch = {
                        focusManager.clearFocus(force = true)
                    }),
                    textStyle = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.Black, fontSize = 18.sp)
                )
            }
        }
    }
}