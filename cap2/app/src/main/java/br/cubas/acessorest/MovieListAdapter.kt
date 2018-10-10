package br.cubas.acessorest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.move_item.view.*

class MovieListAdapter(private val movies: List<Movie>?,
                       private val context: Context) : Adapter<MovieListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies?.get(position)
        movie?.let { holder.bindView(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.move_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        movies?.let {
            return it.size
        }
        return 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(movie: Movie) {
            val title = itemView.movie_item_title
            val type = itemView.movie_item_type
            title.text = movie.title
            type.text = movie.type
        }
    }

}

