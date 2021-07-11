package com.darshan.merchant.orders.domain.injection

import com.darshan.merchant.orders.domain.LoadOrdersUseCase
import com.darshan.merchant.orders.repository.injection.LoadOrdersRepositoryModule
import com.darshan.ordermerchantapp.orderscreen.domain.LoadOrdersUseCaseImpl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [LoadOrdersRepositoryModule::class])
class LoadOrdersUseCaseModule {

    @Provides
    fun provideLoadOrdersUseCase(usecase: LoadOrdersUseCaseImpl): LoadOrdersUseCase =
        usecase

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}