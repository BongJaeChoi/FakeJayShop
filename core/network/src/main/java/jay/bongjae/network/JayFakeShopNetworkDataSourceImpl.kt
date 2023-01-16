package jay.bongjae.network

import jay.bongjae.common.Dispatcher
import jay.bongjae.common.JayFakeShopDispatchers
import jay.bongjae.network.model.NetworkProduct
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JayFakeShopNetworkDataSourceImpl @Inject constructor(
    @Dispatcher(JayFakeShopDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val apiService: JayStoreService
) : JayFakeShopNetworkDataSource {
    override suspend fun getProducts(): List<NetworkProduct> =
        withContext(ioDispatcher) {
            apiService.getProducts()
        }
}
