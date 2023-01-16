package jay.bongjae.data.repository

import jay.bongjae.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProduct(): Flow<List<Product>>
}
