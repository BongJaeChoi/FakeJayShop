package jay.bongjae.network.model


import jay.bongjae.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkRating(
    @SerialName("count")
    val count: Int,
    @SerialName("rate")
    val rate: Double
)

fun NetworkRating.asExternalModel() = Rating(
    count = count,
    rate = rate
)
