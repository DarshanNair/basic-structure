package com.darshan.merchant.core.injection

import android.app.Application
import com.darshan.merchant.core.OrdersApplication
import com.darshan.merchant.core.injection.scopes.PerApplication
import com.darshan.merchant.core.network.api.injection.OrdersApiModule
import com.darshan.merchant.orders.injection.OrdersActivityBuilderModule
import dagger.BindsInstance
import dagger.Component

@PerApplication
@Component(
    modules = [
        BaseModule::class,
        OrdersApiModule::class,
        OrdersActivityBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: OrdersApplication)

}