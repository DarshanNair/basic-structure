package com.darshan.merchant.orders.model

import org.joda.time.DateTime

data class Order(
    val id: Int,
    val title: String,
    val quantity: Int,
    val createdAt: DateTime,
    val alarmAt: DateTime,
    val expireAt: DateTime,
    val addons: List<Addon>,
    var isApplied: Boolean = false
)

data class Addon(
    val id: Int,
    val title: String,
    val quantity: Int
)