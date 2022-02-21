package `in`.privin.githubapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofit {

    private const val BASE_URL = "https://api.github.com/"

    private val okHttpClient = OkHttpClient()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()



    fun create() = retrofit.create(GithubRemoteClient::class.java)
}