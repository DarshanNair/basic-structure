package com.darshan.merchant.orders.repository

import com.darshan.merchant.core.network.api.OrdersApi
import com.darshan.merchant.core.network.model.CustomerOrders
import io.reactivex.Single
import javax.inject.Inject

class LoadOrdersRepositoryImpl @Inject constructor(
    private val ordersApi: OrdersApi
) : LoadOrdersRepository {

    override fun getOrders(): Single<CustomerOrders> = ordersApi.getOrders()

}