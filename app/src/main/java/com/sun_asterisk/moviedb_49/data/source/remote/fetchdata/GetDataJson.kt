package com.sun_asterisk.moviedb_49.data.source.remote.fetchdata

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.moviedb_49.utils.Constant

class GetDataJson(private val listener: OnFetchDataJsonListener<Movie>) {
    fun getDate(type: String, page: Int) {
        val url =
            Constant.BASE_URL + type + Constant.BASE_API_KEY +
                    Constant.BASE_LANGUAGE + Constant.BASE_PAGE + page
        GetMovieJsonFromUrl(listener).execute(url)
    }
}
