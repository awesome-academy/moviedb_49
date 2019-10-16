package com.sun_asterisk.moviedb_49.data.source.remote.fetchdata

import android.os.AsyncTask
import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.moviedb_49.utils.Constant

class GetMovieJsonFromUrl(private val listener: OnFetchDataJsonListener<Movie>) :
    AsyncTask<String, Unit, MutableList<Movie>>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg string: String?): MutableList<Movie> {
        var movies = mutableListOf<Movie>()
        try {
            val parenJson = ParseUrlToJson()
            val data = parenJson.getJsonFromUrl(string[0])
            movies = parenJson.parseJsonToMovies(data)
        } catch (e: Exception) {
            exception = e
        }
        return movies
    }

    override fun onPostExecute(result: MutableList<Movie>?) {
        super.onPostExecute(result)
        result?.let {
            listener.onSuccess(result)
        }?: listener.onFail(exception ?: Exception(Constant.MESSENGER))
    }
}
