package com.darshan.merchant.orders.viewmodel

import androidx.lifecycle.MutableLiveData
import com.darshan.merchant.orders.domain.LoadOrdersUseCase
import com.darshan.merchant.orders.model.Order
import javax.inject.Inject

class OrdersViewModelImpl @Inject internal constructor(
    private val loadOrdersUseCase: LoadOrdersUseCase
) : OrdersViewModel() {

    private val stateLiveData = MutableLiveData<State>()

    init {
        loadOrdersUseCase.setCallback(this)
    }

    override val state = stateLiveData

    override fun loadOrders() {
        stateLiveData.value = State.Loading
        loadOrdersUseCase.execute()
    }

    override fun onOrdersFetchSuccess(orders: List<Order>) {
        stateLiveData.value = State.Success(orders)
    }

    override fun onOrdersFetchError(throwable: Throwable) {
        //TODO
    }

    public override fun onCleared() {
        super.onCleared()
        loadOrdersUseCase.cleanup()
    }

}