package fr.iut.cinecool.API.OSM

import fr.iut.cinecool.model.CinemaResult
import fr.iut.cinecool.model.RouteResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun searchCinemas(
        @Query("q") query: String,
        @Query("format") format: String = "json"
    ): Call<List<CinemaResult>>

    @GET("v2/directions/driving-car")
    fun getRoute(
        @Query("api_key") apiKey: String,
        @Query("start") start: String,
        @Query("end") end: String
    ): Call<RouteResult>
}
