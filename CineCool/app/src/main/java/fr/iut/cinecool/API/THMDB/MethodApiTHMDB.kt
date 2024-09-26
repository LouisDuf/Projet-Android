package fr.iut.cinecool.API.THMDB

class MethodApiTHMDB {
    private val apiService = ApiClientTHMDB.apiService

    suspend fun getPopularMovies(apiKey: String, page: Int): MovieResponse {
        return apiService.getPopularMovies(apiKey, page)
    }

    suspend fun searchMovies(apiKey: String, query: String, page: Int): MovieResponse {
        return apiService.searchMovies(apiKey, query, page)
    }
}
