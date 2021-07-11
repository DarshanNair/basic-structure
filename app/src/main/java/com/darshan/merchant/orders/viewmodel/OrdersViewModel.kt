package com.darshan.merchant.orders.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.darshan.merchant.orders.domain.LoadOrdersUseCase
import com.darshan.merchant.orders.model.Order

abstract class OrdersViewModel : ViewModel(), LoadOrdersUseCase.Callback {

    sealed class State {
        object Loading : State()
        data class Success(val orders: List<Order>) : State()
    }

    abstract val state: LiveData<State>

    abstract fun loadOrders()

}