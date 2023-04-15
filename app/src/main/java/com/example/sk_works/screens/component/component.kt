package com.example.sk_works.screens.component


import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.ActivityNavigatorExtras
import com.example.sk_works.R
import com.example.sk_works.screens.shop.addProducts.AddProductViewModel


//@Preview()
@Composable
fun ItemRow2(
    modifier: Modifier = Modifier,
    title: String = "Steel Door",
    showSold: Boolean = true,
    sold: Int = 132,
    rating: Double = 4.0,
    rated: Int = 123,
    price: Int = 40000,
    deliveryMsg: String = "Get it in a week",
    deliveryCharge: String = "Free Delivery by SK",
) {
    val screenW = LocalConfiguration.current.screenWidthDp.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .then(modifier),
        shape = RoundedCornerShape(15.dp),
        color = Color(0xffF1F1F1),
        elevation = 10.dp
    ) {

        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(screenW / 3)
                    .padding(start = 20.dp, top = 10.dp, bottom = 10.dp),
                elevation = 5.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color.Blue
            ) {

            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)

//                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//                    StatusCard(status = "Under Process")
//
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    Divider(modifier = Modifier.height(20.dp).width(1.dp), color = Color(0xFFB3B3B3))
//
//                    Spacer(modifier = Modifier.width(8.dp))
//                }

                if (showSold) {
                    ShowRating_Solded(rating = rating, rated = rated, sold = sold)
                }

                Text(
                    text = "₹${price}",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF54444),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )

                Text(
                    text = deliveryMsg,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xffFF969696)
                )

                Text(
                    text = deliveryCharge,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Composable
fun MessageCard(message: String) {
    Card(
        modifier = Modifier
            .width(intrinsicSize = IntrinsicSize.Max)
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(0.dp),
        shape = RoundedCornerShape(7.dp),
        backgroundColor = Color(0xffD9D9D9)
    ) {
        Text(
            text = message,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
        )
    }
}

//Show rating with number of product solded(selled)
@Composable
fun ShowRating_Solded(rating: Double, rated: Int, sold: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.star_t),
            contentDescription = null,
            modifier = Modifier.size(15.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = rating.toString(), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        Text(text = "(${rated.toString()})", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.width(8.dp))

        Divider(
            modifier = Modifier
                .height(15.dp)
                .width(1.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        MessageCard(message = "${193} Sold")

    }
}


//Show product
//@Preview
@Composable
fun ItemBox(onClick:() -> Unit) {
    Surface(
        modifier = Modifier
            .height(210.dp)
            .width(130.dp)
            .padding(3.dp)
        ,
        color = Color.Transparent,
        shape = RoundedCornerShape(9.dp)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Surface(
                modifier = Modifier
                    .size(125.dp)
                    .padding(5.dp)
                    .clickable { onClick() }
                , color = Color.Yellow, shape = RoundedCornerShape(8.dp)
            ) {}

            Text(
                text = "Sparx Sport shoes for Mens",
                maxLines = 3,
//                fontWeight = FontWeight.Medium,
//                color = Color.DarkGray,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 5.dp).padding(top = 3.dp).clickable { onClick() }
            )
            Text(
                text = "₹40,000",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp)
            )

        }

    }
}


@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    value: MutableState<String>,
    placerHolder: String = "",
    singleLine: Boolean = false,
    maxLines: Int = 1000,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {

    Column(modifier = Modifier.padding(horizontal = 3.dp)) {
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

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
            placeholder = { Text(text = placerHolder) },
            singleLine = singleLine,
            maxLines = maxLines,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
    }
}

@Composable
fun CustomDropDownMenu(text: String, selected: MutableState<String>, menuItem: List<String>) {

    var expanded by rememberSaveable { mutableStateOf(false) }

//    var selected = rememberSaveable { mutableStateOf("") }

    var dTextFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }




    Column(modifier = Modifier.padding(horizontal = 3.dp)) {

        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))


        OutlinedTextField(
            value = selected.value,
            onValueChange = { selected.value = it },
            shape = RoundedCornerShape(10.dp),
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    dTextFieldSize = coordinates.size.toSize()
                }
                .shadow(elevation = 12.dp)
                .clickable { expanded = !expanded },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded })
            },
            placeholder = { Text(text = "Click here to select") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFDBDBDB),
                unfocusedBorderColor = Color.Transparent,
                backgroundColor = Color(0xFFFEFEFE),
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {

            menuItem.forEach { item ->
                DropdownMenuItem(onClick = {
                    selected.value = item
                    expanded = false
                }) {
                    Text(text = item)
                }
            }

        }
    }
}


//@Preview(showSystemUi = true)
@Composable
fun TakeMultiDesign(viewModel:AddProductViewModel) {
    //Take multiple design and there size



    val designName = rememberSaveable { mutableStateOf("") }
    val screenW = LocalConfiguration.current.screenWidthDp.dp

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }




    Column(
        modifier = Modifier
            .padding(horizontal = 7.dp)
    ) {


        InputTextField(
            text = "Design Name?",
            value = designName,
            placerHolder = "eg: Flower Design",
            maxLines = 3,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { })
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = "Design Image (from Front):",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            modifier = Modifier
                .size(110.dp)
                .clickable {
                    launcher.launch("image/*")
                },
            shape = RoundedCornerShape(9.dp),
            elevation = 9.dp,
        ) {

            if (imageUri == null) {

                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(30.dp)
                )
            } else {
                imageUri?.let {
                    if (Build.VERSION.SDK_INT < 28) {
                        bitmap.value = MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)

                    } else {
                        val source = ImageDecoder
                            .createSource(context.contentResolver, it)
                        bitmap.value = ImageDecoder.decodeBitmap(source)
                    }

                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(400.dp)
                        )
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Related Images:",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 7.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

            Surface(
                modifier = Modifier
                    .size(screenW / 4)
                    .clickable {},
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

        Spacer(modifier = Modifier.height(20.dp))


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

            Column(modifier = Modifier.width(screenW/2)) {

                OutlinedButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(screenW / 2)
                        .height(50.dp)
                        .padding(horizontal = 5.dp),
                    elevation = ButtonDefaults.elevation(8.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Black)
                ) {
                    Text(text = "Size", fontWeight = FontWeight.Bold, color = Color.White)
                }

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "Eg: 6 4 (6ftx4ft)") }
                )


            }


            Column(modifier = Modifier.width(screenW/2)) {
                OutlinedButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(screenW / 2)
                        .height(50.dp)
                        .padding(horizontal = 5.dp),
                    elevation = ButtonDefaults.elevation(8.dp),
                    shape = RoundedCornerShape(7.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Black)
                ) {
                    Text(text = "Price", fontWeight = FontWeight.Bold, color = Color.White)
                }

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = {})
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = {})
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") }
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = {})
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = {})
                )

                Spacer(modifier = Modifier.height(7.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(screenW / 2)
                        .padding(4.dp)
                        .shadow(elevation = 12.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDBDBDB),
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color(0xFFFEFEFE),
                    ),
                    placeholder = { Text(text = "eg: 5000") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(onNext = {})
                )
            }
        }

        Text(
            text = "Add More Sizes and Price.",
            color = Color.Blue.copy(alpha = 0.7f),
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.End)
                .clickable { },
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

    }
}


@Composable
fun Dummy(viewModel: AddProductViewModel){
    val l = remember {mutableStateOf(1)}

    val values = hashMapOf<Any, MutableState<String?>>("v" to remember { mutableStateOf("") })

    val focusManager = LocalFocusManager.current


    Column(modifier = Modifier.fillMaxSize()) {


        repeat(l.value) {
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = viewModel.values["v{${l.value}}"]!! ,
                onValueChange = {viewModel.values["v{${l.value}}"] = it},
                modifier = Modifier
                    .padding(4.dp)
                    .shadow(elevation = 12.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFDBDBDB),
                    unfocusedBorderColor = Color.Transparent,
                    backgroundColor = Color(0xFFFEFEFE),
                ),
                placeholder = { Text(text = "eg: 5000") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(onNext = {focusManager.moveFocus(focusDirection = FocusDirection.Down)})
            )

        }


        Text(text = "ADD", modifier = Modifier.clickable { l.value += 1 })
    }
}

@Composable
fun HeightLightBannerCard(){
    val screenW = LocalConfiguration.current.screenWidthDp.dp

    Surface(
        modifier = Modifier
            .height(screenW / 2 + 100.dp)
            .width(screenW / 2)
            .padding(9.dp),
        color = Color.Transparent
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Surface(
                modifier = Modifier
                    .width(screenW / 2)
                    .height(screenW / 2)
                    .padding(5.dp)
                    .clickable { },
                color = Color.Yellow,
                shape = RoundedCornerShape(8.dp)
            ) {}

            Text(
                text = "Steel Doors,302 Grade,Premium Quality And this is very bla bla bla",
                maxLines = 3,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(5.dp),
                color = Color.Black
            )
            Text(
                text = "₹40,000",
//                            color = Color.Black,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(start = 5.dp)
            )

        }
    }

}