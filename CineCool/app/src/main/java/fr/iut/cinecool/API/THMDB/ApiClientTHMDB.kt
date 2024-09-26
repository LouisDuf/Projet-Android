package fr.iut.cinecool.API.THMDB

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientTHMDB {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
