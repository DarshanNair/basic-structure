package com.darshan.merchant.orders.model

data class DealItem(
    var id: Int,
    var title: String,
    var description: String,
    var price: String,
    var aisle: String,
    var url: String
)