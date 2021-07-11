package com.darshan.merchant.orders.injection

import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darshan.merchant.core.injection.scopes.PerActivity
import com.darshan.merchant.orders.domain.injection.LoadOrdersUseCaseModule
import com.darshan.merchant.orders.view.OrdersActivity
import com.darshan.merchant.orders.viewmodel.OrdersViewModel
import com.darshan.merchant.orders.viewmodel.OrdersViewModelFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LoadOrdersUseCaseModule::class
    ]
)
class OrdersActivityModule {

    @Provides
    @PerActivity
    fun provideContext(activity: OrdersActivity): Context = activity

    @Provides
    @PerActivity
    fun provideOrdersViewModel(
        activity: OrdersActivity,
        factory: OrdersViewModelFactory
    ): OrdersViewModel = ViewModelProvider(activity, factory).get(OrdersViewModel::class.java)

    @Provides
    @PerActivity
    internal fun provideLayoutManager(@PerActivity context: Context): RecyclerView.LayoutManager =
        LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

    @Provides
    @PerActivity
    internal fun provideDividerItemDecoration(@PerActivity context: Context) =
        DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)

    @Provides
    @PerActivity
    internal fun provideLayoutInflator(@PerActivity context: Context) = LayoutInflater.from(context)

}