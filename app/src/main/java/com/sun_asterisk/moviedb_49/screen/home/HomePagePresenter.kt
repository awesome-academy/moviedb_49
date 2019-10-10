package com.sun_asterisk.moviedb_49.screen.home

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.moviedb_49.data.source.repository.MovieRepository

class HomePagePresenter(private val repository: MovieRepository) : HomePageContract.Presenter {

    private var view: HomePageContract.View? = null

    override fun setView(view: HomePageContract.View) {
        this.view = view
    }

    override fun getMoviesByType(endPoint: String, typeMovie: String, page: Int) {
        repository.getData(endPoint, page, object : OnFetchDataJsonListener<Movie> {
            override fun onSuccess(data: MutableList<Movie>) {
                view?.onGetMoviesByTypeSuccess(data, typeMovie)
            }

            override fun onFail(exception: Exception) {
                view?.onError(exception)
            }
        })
    }
}
