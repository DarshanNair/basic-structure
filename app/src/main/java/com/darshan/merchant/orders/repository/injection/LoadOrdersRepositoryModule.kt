package com.darshan.merchant.orders.repository.injection

import com.darshan.merchant.orders.repository.LoadOrdersRepository
import com.darshan.merchant.orders.repository.LoadOrdersRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class LoadOrdersRepositoryModule {

    @Provides
    fun provideLoadOrdersRepository(repository: LoadOrdersRepositoryImpl): LoadOrdersRepository =
        repository

}