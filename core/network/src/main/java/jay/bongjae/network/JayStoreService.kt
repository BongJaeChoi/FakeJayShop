package jay.bongjae.network

import jay.bongjae.network.model.NetworkProduct
import retrofit2.http.GET

//https://fakestoreapi.com/
interface JayStoreService {
    /**
     * GET
    /products
    GET
    /products/1
    GET
    /products/categories
    GET
    /products/category/jewelery
    GET
    /cart?userId=1
    GET
    /products?limit=5
    POST
    /products
    PUT
    /products/1
    PATCH
    /products/1
    DELETE
    /products/1
     */
    @GET("products")
    suspend fun getProducts(): List<NetworkProduct>
}
