package com.sun_asterisk.moviedb_49.data.source.remote.fetchdata

import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.utils.entry.MovieEntry
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

private val TIME_OUT = 15000

class ParseUrlToJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String {
        val url = URL(urlString)
        val httpUrlConnection = url.openConnection().apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            doOutput = true
        }
        httpUrlConnection.connect()
        val inputStream = httpUrlConnection.getInputStream()
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()
        var line: String? = bufferReader.readLine()
        while (line != null) {
            builder.append(line)
            line = bufferReader.readLine()
        }
        bufferReader.close()
        return builder.toString()
    }

    fun parseJsonToMovieObject(jsonObject: JSONObject): Movie = Movie.MovieBuilder()
        .id(jsonObject.getInt(MovieEntry.ID))
        .backDropPathUrl(jsonObject.getString(MovieEntry.BACKDROP_PATH))
        .overView(jsonObject.getString(MovieEntry.OVERVIEW))
        .posterPathUrl(jsonObject.getString(MovieEntry.POSTER_PATH))
        .title(jsonObject.getString(MovieEntry.TITLE))
        .voteAverage(jsonObject.getDouble(MovieEntry.VOTE_AVERAGE))
        .bind()

    fun parseJsonToMovies(string: String): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        val jsonObject = JSONObject(string)
        val jsonArray = jsonObject.getJSONArray(MovieEntry.RESULTS)
        for (i in 0 until jsonArray.length()) {
            val movieJson = jsonArray.getJSONObject(i)
            val movie = parseJsonToMovieObject(movieJson)
            movieList.add(movie)
        }
        return movieList
    }
}
