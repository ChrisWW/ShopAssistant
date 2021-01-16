package com.example.shopassistantproject

data class Shopping(
    var id: Long = 0,
    var product: String,
    var quantity: String,
    var price: String,
    var bought: Boolean)