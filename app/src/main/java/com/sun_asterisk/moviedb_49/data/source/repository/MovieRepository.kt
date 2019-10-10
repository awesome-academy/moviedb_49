package com.sun_asterisk.moviedb_49.data.source.repository

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.MovieDBDataSource
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchDataJsonListener

class MovieRepository private constructor(private val remote: MovieDBDataSource.Remote) {

    fun getData(typeMovie: String, page: Int, listener: OnFetchDataJsonListener<Movie>) {
        remote.getMoviesbyType(typeMovie, page, listener)
    }

    companion object {
        private var instance: MovieRepository? = null

        fun getInstance(remote: MovieDBDataSource.Remote): MovieRepository =
            instance
                ?: MovieRepository(remote).also { instance = it }
    }
}
