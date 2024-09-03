package com.mostafa.paymobtask.core.di

import com.mostafa.paymobtask.core.data.IRepository
import com.mostafa.paymobtask.core.data.Repository
import com.mostafa.paymobtask.core.utils.NetworkConnectionManager
import com.mostafa.paymobtask.core.utils.NetworkConnectionManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindHomeRepository(repository: Repository): IRepository

    @Binds
    abstract fun bindNetworkConnectionManager(networkConnectionManagerImpl: NetworkConnectionManagerImpl): NetworkConnectionManager

}

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {
    @Provides
    @Singleton
    fun provideCoroutineScope() =
        CoroutineScope(Dispatchers.Default + SupervisorJob())
}
