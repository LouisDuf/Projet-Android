package fr.iut.cinecool.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import fr.iut.cinecool.API.THMDB.Movie
import fr.iut.cinecool.API.THMDB.MethodApiTHMDB

class MovieViewModel : ViewModel() {
    private val methodApiTHMDB = MethodApiTHMDB()

    val popularMovies = MutableLiveData<List<Movie>>()
    val searchResults = MutableLiveData<List<Movie>>()

    fun getPopularMovies(apiKey: String, page: Int) {
        viewModelScope.launch {
            val movies = methodApiTHMDB.getPopularMovies(apiKey, page)
            popularMovies.postValue(movies.results)
        }
    }

    fun searchMovies(apiKey: String, query: String, page: Int) {
        viewModelScope.launch {
            val movies = methodApiTHMDB.searchMovies(apiKey, query, page)
            searchResults.postValue(movies.results)
        }
    }
}
