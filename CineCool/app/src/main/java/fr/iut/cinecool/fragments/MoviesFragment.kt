package fr.iut.cinecool.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fr.iut.cinecool.viewModel.MovieViewModel
import fr.iut.cinecool.R
import fr.iut.cinecool.adapter.MovieAdapter
import fr.iut.cinecool.databinding.FragmentMoviesBinding
import fr.iut.cinecool.viewModel.cineViewModel

class MoviesFragment : Fragment() {
    private val sharedViewModel: cineViewModel by activityViewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter

    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        // Observe les changements des données des films populaires
        movieViewModel.popularMovies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.updateMovies(movies)
        }

        // Charge les films populaires
        loadPopularMovies()

        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.movies_to_sessions)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerMovie.setHasFixedSize(true)
        binding.recyclerMovie.layoutManager = LinearLayoutManager(context)

        movieAdapter = MovieAdapter(ArrayList())
        binding.recyclerMovie.adapter = movieAdapter
        movieAdapter.onItemClick = {
            sharedViewModel.setCine(it)
            findNavController().navigate(R.id.movies_to_sessions)
        }

    }

    private fun loadPopularMovies() {
        // Remplacez YOUR_API_KEY par votre clé d'API The Movie DB
        movieViewModel.getPopularMovies("a97243d7813d31446f6c43284e6854d5", 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}