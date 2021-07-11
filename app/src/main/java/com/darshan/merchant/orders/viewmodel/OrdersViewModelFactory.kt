package com.darshan.merchant.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.darshan.merchant.orders.domain.LoadOrdersUseCase
import javax.inject.Inject

class OrdersViewModelFactory @Inject constructor(
    private val loadOrdersUseCase: LoadOrdersUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        OrdersViewModelImpl(
            loadOrdersUseCase
        ) as T

}