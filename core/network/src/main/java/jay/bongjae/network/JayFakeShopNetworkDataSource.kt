package jay.bongjae.network

import jay.bongjae.network.model.NetworkProduct

interface JayFakeShopNetworkDataSource {
    suspend fun getProducts(): List<NetworkProduct>
}
