package jay.bongjae.network.model


import jay.bongjae.model.Product
import jay.bongjae.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkProduct(
    @SerialName("category")
    val category: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("price")
    val price: Double,
    @SerialName("rating")
    val networkRating: NetworkRating,
    @SerialName("title")
    val title: String
)

fun NetworkProduct.asExternalModel() =
    Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = Rating(count = networkRating.count, rate = networkRating.rate),
        title = title
    )
