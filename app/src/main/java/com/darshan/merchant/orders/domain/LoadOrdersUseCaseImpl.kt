package com.darshan.ordermerchantapp.orderscreen.domain

import com.darshan.merchant.core.domain.BaseUseCase
import com.darshan.merchant.core.injection.qualifiers.ForIoThread
import com.darshan.merchant.core.injection.qualifiers.ForMainThread
import com.darshan.merchant.core.network.model.CustomerOrders
import com.darshan.merchant.orders.domain.LoadOrdersUseCase
import com.darshan.merchant.orders.domain.LoadOrdersUseCase.Callback
import com.darshan.merchant.orders.model.Order
import com.darshan.merchant.orders.repository.LoadOrdersRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import javax.inject.Inject


class LoadOrdersUseCaseImpl @Inject constructor(
    compositeDisposable: CompositeDisposable,
    private val loadOrdersRepository: LoadOrdersRepository,
    @ForIoThread private val ioScheduler: Scheduler,
    @ForMainThread private val mainScheduler: Scheduler
) : BaseUseCase(compositeDisposable), LoadOrdersUseCase {

    private var callback: Callback? = null

    override fun execute() {
        trackDisposable(
            loadOrdersRepository.getOrders()
                .map { map(it) }
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
                .subscribe(::onSuccess, ::onError)
        )
    }

    override fun setCallback(callback: Callback) {
        this.callback = callback
    }

    override fun cleanup() {
        callback = null
        super.cleanup()
    }

    private fun onSuccess(deals: List<Order>) {
        callback?.onOrdersFetchSuccess(deals)
    }

    private fun onError(throwable: Throwable) {
        callback?.onOrdersFetchError(throwable)
    }

    private fun map(orders: CustomerOrders): List<Order> {
        val format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
        val formatter: DateTimeFormatter = DateTimeFormat.forPattern(format)

        val order = mutableListOf<Order>()
        orders.data.forEach {
            order.add(
                Order(
                    id = it.id,
                    title = it.title,
                    quantity = it.quantity,
                    createdAt = DateTime.parse(it.createdAt, formatter),
                    alarmAt = DateTime.parse(it.alertedAt, formatter),
                    expireAt = DateTime.parse(it.expiredAt, formatter),
                    addons = emptyList()
                )
            )
        }
        return order
    }

}
