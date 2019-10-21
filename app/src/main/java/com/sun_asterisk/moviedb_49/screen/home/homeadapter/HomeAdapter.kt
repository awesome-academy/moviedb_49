package com.sun_asterisk.moviedb_49.screen.home.homeadapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.moviedb_49.R
import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchImageListener
import com.sun_asterisk.moviedb_49.data.source.remote.fetchdata.GetImageByAsyncTask
import com.sun_asterisk.moviedb_49.utils.Constant
import kotlinx.android.synthetic.main.items_movies.view.*

class HomeAdapter(private var listMovie: List<Movie>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_movies,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.onBind(movie)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var imageView: ImageView? = null
        private var title: TextView? = null

        init {
            title = itemView.textNameMovies
            imageView = itemView.imageMovies
        }

        fun onBind(movie: Movie) {
            title?.text = movie.title
            getImage(movie)
        }

        private fun getImage(movie: Movie) {
            val imageUrl = Constant.BASE_IMAGE_URL_POSTER + movie.posterPathUrl
            GetImageByAsyncTask(object : OnFetchImageListener {
                override fun loadedImage(bitmap: Bitmap) {
                    imageView?.setImageBitmap(bitmap)
                }

                override fun onFail(exception: Exception) {
                }
            }).execute(imageUrl)
        }
    }
}
