package com.darshan.merchant.core.network.api

import com.darshan.merchant.core.network.model.CustomerOrders
import io.reactivex.Single
import retrofit2.http.GET

interface OrdersApi {

    @GET("orders")
    fun getOrders(): Single<CustomerOrders>

}