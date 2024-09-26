package fr.iut.cinecool.API.OSM

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientOSM {
    private const val OSM_BASE_URL = "https://nominatim.openstreetmap.org/"
    private const val ORS_BASE_URL = "https://api.openrouteservice.org/"

    fun getOSMClient(): ApiService {
        return Retrofit.Builder()
            .baseUrl(OSM_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getORSClient(): ApiService {
        return Retrofit.Builder()
            .baseUrl(ORS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
