package com.darshan.merchant.orders.repository

import com.darshan.merchant.core.network.model.CustomerOrders
import io.reactivex.Single

interface LoadOrdersRepository {

    fun getOrders(): Single<CustomerOrders>

}