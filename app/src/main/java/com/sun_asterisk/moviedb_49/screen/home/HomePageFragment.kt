package com.sun_asterisk.moviedb_49.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun_asterisk.moviedb_49.R
import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.MovieRemoteDataSource
import com.sun_asterisk.moviedb_49.data.source.repository.MovieRepository
import com.sun_asterisk.moviedb_49.utils.Category
import com.sun_asterisk.moviedb_49.utils.Constant

class HomePageFragment : Fragment(), HomePageContract.View {

    private lateinit var presenter: HomePageContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onGetMoviesByTypeSuccess(movies: List<Movie>, type: String) {
    }

    override fun onError(exception: Exception) {
    }

    private fun initData() {
        val dataRemote = MovieRemoteDataSource.getInstance()
        val movieSource = MovieRepository.getInstance(dataRemote)
        presenter = HomePagePresenter(movieSource)
        presenter.setView(this)
        getData()
    }

    private fun getData() {
        presenter.run {
            getMoviesByType(Constant.MOVIE_POPULAR, Category.POPULAR)
            getMoviesByType(Constant.MOVIE_UP_COMING, Category.UP_COMING)
            getMoviesByType(Constant.MOVIE_NOW_PLAYING, Category.NOW_PLAYING)
            getMoviesByType(Constant.MOVIE_TOP_RATE, Category.TOP_RATE)
        }
    }
}
