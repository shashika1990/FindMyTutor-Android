package lk.fmt.findmytutor.services.api.retrofit

import lk.fmt.findmytutor.configurations.AppDefaults
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitConfig {

    private lateinit var retrofit: Retrofit

    fun init() {
        val baseUrl = AppDefaults.getBaseUrl()
        retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getInstance(): Retrofit {
        return retrofit
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(3, TimeUnit.MINUTES)
        .build()

}