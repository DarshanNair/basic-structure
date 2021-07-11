package com.darshan.merchant.core.network.model

import com.google.gson.annotations.SerializedName

data class CustomerOrders(
    val data: List<Order>
)

data class Order(
    val id: Int,
    val title: String,
    val quantity: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("alerted_at") val alertedAt: String,
    @SerializedName("expired_at") val expiredAt: String,
    val addons: List<Addon>,
    var isApplied: Boolean = false
)

data class Addon(
    val id: Int,
    val title: String,
    val quantity: Int
)