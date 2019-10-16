package com.sun_asterisk.moviedb_49.data.source.remote

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.MovieDBDataSource
import com.sun_asterisk.moviedb_49.data.source.remote.fetchdata.GetDataJson

class MovieRemoteDataSource private constructor() : MovieDBDataSource.Remote {

    override fun getMoviesbyType(typeMovie: String, page: Int, listener: OnFetchDataJsonListener<Movie>) =
        GetDataJson(listener).getDate(typeMovie, page)

    companion object {
        private var instance: MovieRemoteDataSource? = null
        fun getInstance(): MovieRemoteDataSource = instance ?: MovieRemoteDataSource()
    }
}
