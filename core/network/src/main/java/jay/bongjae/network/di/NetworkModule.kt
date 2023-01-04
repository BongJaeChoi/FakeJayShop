package jay.bongjae.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jay.bongjae.network.JayStoreService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        networkJson: Json
    ): JayStoreService =
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            ).addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                networkJson.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(JayStoreService::class.java)
}
