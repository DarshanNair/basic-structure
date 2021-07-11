package com.darshan.merchant.orders.domain

import com.darshan.merchant.core.domain.UseCase
import com.darshan.merchant.orders.model.Order

interface LoadOrdersUseCase : UseCase {

    fun execute()

    fun setCallback(callback: Callback)

    interface Callback {
        fun onOrdersFetchSuccess(orders: List<Order>)
        fun onOrdersFetchError(throwable: Throwable)
    }

}