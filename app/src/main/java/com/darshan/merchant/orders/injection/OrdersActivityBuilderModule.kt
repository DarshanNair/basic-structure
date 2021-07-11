package com.darshan.merchant.orders.injection

import com.darshan.merchant.core.injection.scopes.PerActivity
import com.darshan.merchant.orders.view.OrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OrdersActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [OrdersActivityModule::class])
    abstract fun bindOrdersActivity(): OrdersActivity

}