package fr.iut.cinecool.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.iut.cinecool.R
import fr.iut.cinecool.API.THMDB.Movie

class MovieAdapter(private var moviesList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var onItemClick : ((Movie)->Unit)?=null
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val MovieName = itemView.findViewById<TextView>(R.id.MovieName)
        val OtherInformations = itemView.findViewById<TextView>(R.id.OtherInformations)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.no_pictures)
            .into(holder.imageView)

        holder.MovieName.text = movie.title
        holder.OtherInformations.text = movie.overview
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movie)
        }

        // Pour cet exemple, je mets l'overview en tant qu'OtherInformations, vous pouvez le personnaliser selon vos besoins
    }

    // Ajoutez cette méthode pour mettre à jour la liste des films
    fun updateMovies(newMovies: List<Movie>) {
        moviesList = newMovies
        notifyDataSetChanged()
    }
}