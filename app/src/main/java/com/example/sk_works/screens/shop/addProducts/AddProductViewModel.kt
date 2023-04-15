package com.example.sk_works.screens.shop.addProducts


import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel



class AddProductViewModel:ViewModel() {

    val product = hashMapOf<String,Any>()
    val values = hashMapOf<String,String>()

}