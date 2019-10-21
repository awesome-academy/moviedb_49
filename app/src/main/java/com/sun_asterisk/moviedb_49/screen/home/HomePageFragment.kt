package com.sun_asterisk.moviedb_49.screen.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.sun_asterisk.moviedb_49.R
import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.MovieRemoteDataSource
import com.sun_asterisk.moviedb_49.data.source.repository.MovieRepository
import com.sun_asterisk.moviedb_49.screen.home.homeadapter.HomeAdapter
import com.sun_asterisk.moviedb_49.utils.Category
import com.sun_asterisk.moviedb_49.utils.Constant
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*

class HomePageFragment : Fragment(), HomePageContract.View {

    private lateinit var presenter: HomePageContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        // set recyclerView
        view.recyclerPopular.layoutManager =
            activity?.let { LinearLayoutManager(it, HORIZONTAL, false) }
        view.recyclerPopular.setHasFixedSize(true)

        view.recyclerUpcoming.layoutManager =
            activity?.let { LinearLayoutManager(it, HORIZONTAL, false) }
        view.recyclerUpcoming.setHasFixedSize(true)

        view.recyclerNowPlaying.layoutManager =
            activity?.let { LinearLayoutManager(it, HORIZONTAL, false) }
        view.recyclerNowPlaying.setHasFixedSize(true)

        view.recyclerTopRate.layoutManager =
            activity?.let { LinearLayoutManager(it, HORIZONTAL, false) }
        view.recyclerTopRate.setHasFixedSize(true)

        view.recyclerViewTopMovie.layoutManager =
            activity?.let { LinearLayoutManager(it, HORIZONTAL, false) }
        return view
    }

    override fun onGetMoviesByTypeSuccess(movies: List<Movie>, type: String) {
        when (type) {
            Category.POPULAR -> recyclerPopular.adapter = HomeAdapter(movies)

            Category.UP_COMING -> recyclerUpcoming.adapter = HomeAdapter(movies)

            Category.NOW_PLAYING -> recyclerNowPlaying.adapter = HomeAdapter(movies)

            Category.TOP_RATE -> recyclerTopRate.adapter = HomeAdapter(movies)
        }
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
