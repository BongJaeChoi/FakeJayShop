package jay.bongjae.network

import jay.bongjae.network.model.Product

interface JayFakeShopNetworkDataSource {
    suspend fun getProducts(): List<Product>
}
