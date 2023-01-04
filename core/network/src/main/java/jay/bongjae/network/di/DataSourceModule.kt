package jay.bongjae.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jay.bongjae.network.JayFakeShopNetworkDataSource
import jay.bongjae.network.JayFakeShopNetworkDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun JayFakeShopNetworkDataSourceImpl.binds(): JayFakeShopNetworkDataSource
}
