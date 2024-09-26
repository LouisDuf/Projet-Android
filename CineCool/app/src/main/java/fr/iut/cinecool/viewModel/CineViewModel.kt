package fr.iut.cinecool.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.iut.cinecool.API.THMDB.Movie


class cineViewModel : ViewModel() {
    private val _cine = MutableLiveData<Movie>()
    val cine: LiveData<Movie> = _cine

    fun setCine(cine: Movie) {
        _cine.value = cine
    }

}
