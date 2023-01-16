package jay.bongjae.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jay.bongjae.data.repository.ProductRepository
import jay.bongjae.data.repository.ProductRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsProductRepository(
        productRepository: ProductRepositoryImpl
    ): ProductRepository
}
