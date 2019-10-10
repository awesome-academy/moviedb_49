package com.sun_asterisk.moviedb_49.data.source

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchDataJsonListener

interface MovieDBDataSource {

    interface Remote {
        fun getMoviesbyType(typeMovie: String, page: Int, listener: OnFetchDataJsonListener<Movie>)
    }
}
