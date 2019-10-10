package com.sun_asterisk.moviedb_49.screen.home

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.utils.BasePresenter
import com.sun_asterisk.moviedb_49.utils.Constant

interface HomePageContract {
    interface View {
        fun onGetMoviesByTypeSuccess(movies: List<Movie>, type: String)

        fun onError(exception: Exception)
    }

    interface Presenter : BasePresenter<View> {
        fun getMoviesByType(endPoint: String, typeMovie: String, page: Int = Constant.DEFAULT_PAGE)
    }
}
