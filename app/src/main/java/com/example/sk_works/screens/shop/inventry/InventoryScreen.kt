package com.example.sk_works.screens.shop.inventry

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sk_works.screens.shop.mainScreen.InventoryOption
import com.example.sk_works.screens.shop.mainScreen.InventoryOption
import com.example.sk_works.R


@Preview
@Composable
fun InventoryScreen(){
    Row(modifier = Modifier.fillMaxSize()){
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            InventoryOption(text = "Edit Added \nProduct",Icon = R.drawable.edit)
            Spacer(modifier = Modifier.height(15.dp))
            InventoryOption(text = "Edit Service \nRegion",Icon = R.drawable.edit)
        }
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            InventoryOption(text = "Add\n Products",Icon = R.drawable.add)
            Spacer(modifier = Modifier.height(15.dp))
            InventoryOption(text = "Add New\n Banner",Icon = R.drawable.add)
            Spacer(modifier = Modifier.height(15.dp))
            InventoryOption(text = "Add New\n Region",Icon = R.drawable.add)

        }
        
    }
}