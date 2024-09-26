package fr.iut.cinecool.API.OSM
import fr.iut.cinecool.model.CinemaResult
import fr.iut.cinecool.model.RouteResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MethodApiOSM {

    fun searchCinemas(latitude: Double, longitude: Double) {
        val apiService = ApiClientOSM.getOSMClient()
        val call = apiService.searchCinemas("cinema near $latitude,$longitude")
        call.enqueue(object : Callback<List<CinemaResult>> {
            override fun onResponse(call: Call<List<CinemaResult>>, response: Response<List<CinemaResult>>) {
                val cinemas = response.body()
                // Trouvez le cinéma le plus proche ou affichez la liste des cinémas
                // Puis, utilisez la fonction getRoute() pour obtenir l'itinéraire
            }

            override fun onFailure(call: Call<List<CinemaResult>>, t: Throwable) {
                // Gérer l'échec
            }
        })
    }

    fun getRoute(startLat: Double, startLon: Double, endLat: Double, endLon: Double) {
        val apiKey = "5b3ce3597851110001cf6248953315121da3401d85fa50fce9c0991e"
        val apiService = ApiClientOSM.getORSClient()
        val call = apiService.getRoute(apiKey, "$startLat,$startLon", "$endLat,$endLon")
        call.enqueue(object : Callback<RouteResult> {
            override fun onResponse(call: Call<RouteResult>, response: Response<RouteResult>) {
                val routeResult = response.body()
                val steps = routeResult?.routes?.get(0)?.segments?.get(0)?.steps
                if (steps != null) {
                    // Utilisez les instructions de l'itinéraire pour guider l'utilisateur
                } else {
                    // Gérer le cas où il n'y a pas d'itinéraire disponible
                }
            }

            override fun onFailure(call: Call<RouteResult>, t: Throwable) {
                // Gérer l'échec
            }
        })
    }

}