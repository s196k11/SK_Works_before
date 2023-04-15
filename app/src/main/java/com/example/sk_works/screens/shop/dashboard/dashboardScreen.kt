package com.example.sk_works.screens.shop.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sk_works.screens.shop.mainScreen.DashboardPart
import com.example.sk_works.screens.shop.mainScreen.DashboardPart

@Preview
@Composable
fun DashboardScreen(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState()),) {

        DashboardPart(
            title1 = "Total Orders:", subtitle1 = "187", onClick1 = {},
            title2 = "Pending Orders:", subtitle2 = "100", onClick2 = {},
            title3 = "Completed Orders:", subtitle3 = "90", onClick3 = {},
            title4 = "Orders Under Verification:", subtitle4 = "7", onClick4 = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        thickness = 2.dp)

        Spacer(modifier = Modifier.height(10.dp))

        DashboardPart(
            title1 = "Total Sales:", subtitle1 = "₹14587", onClick1 = {},
            title2 = "Today's Sales:", subtitle2 = "₹10,000", onClick2 = {},
            title3 = "Pending Balance:", subtitle3 = "₹90,230", onClick3 = {},
        )

        Spacer(modifier = Modifier.height(10.dp))

        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(10.dp))

        DashboardPart(title1 = "Total Visits:", subtitle1 = "34,00", onClick1 = {},
            title2 = "Today's Visits:", subtitle2 = "400", onClick2 = {},
            title3 = "Pending Visits:", subtitle3 = "200", onClick3 = {},
            title4 = "Succeed Visits:", subtitle4 = "3000", onClick4 = {}
        )

    }
}
