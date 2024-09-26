package fr.iut.cinecool.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import fr.iut.cinecool.R
import fr.iut.cinecool.viewModel.cineViewModel

class MovieDetailFragment : Fragment() {
    private val sharedViewModel: cineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return  view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        val button = view.findViewById<ImageButton>(R.id.returnButton)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_SessionFragment_to_fragment_movies)
        }
    }
    private fun init() {
        requireView().findViewById<TextView>(R.id.title).text= sharedViewModel.cine.value?.title
        val desc = requireView().findViewById<TextView>(R.id.description)
        desc.text=sharedViewModel.cine.value?.overview
        desc.isScrollContainer = true
        desc.movementMethod = ScrollingMovementMethod()
        val img=requireView().findViewById<ImageView>(R.id.afficheFilm)

        val imageUrl = "https://image.tmdb.org/t/p/w500${sharedViewModel.cine.value?.poster_path}"

        Glide.with(this.requireContext())
            .load(imageUrl)
            .placeholder(R.drawable.no_pictures)
            .into(img)
    }
}