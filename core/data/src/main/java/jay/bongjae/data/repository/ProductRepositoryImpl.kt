package jay.bongjae.data.repository

import jay.bongjae.common.Dispatcher
import jay.bongjae.common.JayFakeShopDispatchers
import jay.bongjae.model.Product
import jay.bongjae.network.JayFakeShopNetworkDataSource
import jay.bongjae.network.model.NetworkProduct
import jay.bongjae.network.model.asExternalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    @Dispatcher(JayFakeShopDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val jayFakeShopNetworkDataSource: JayFakeShopNetworkDataSource
) : ProductRepository {
    override suspend fun getProduct(): Flow<List<Product>> =
        flow {
            emit(
                jayFakeShopNetworkDataSource.getProducts()
                    .map(NetworkProduct::asExternalModel)
            )
        }.flowOn(ioDispatcher)

}
