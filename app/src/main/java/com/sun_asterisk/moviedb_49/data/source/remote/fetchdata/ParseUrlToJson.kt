package com.sun_asterisk.moviedb_49.data.source.remote.fetchdata

import com.sun_asterisk.moviedb_49.data.model.Genres
import com.sun_asterisk.moviedb_49.data.model.Movie
import com.sun_asterisk.moviedb_49.utils.entry.GenresEntry
import com.sun_asterisk.moviedb_49.utils.entry.MovieEntry
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseUrlToJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String {
        val url = URL(urlString)
        val httpUrlConnection = url.openConnection().apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
        } as HttpURLConnection
        httpUrlConnection.requestMethod = GET

        httpUrlConnection.connect()
        val inputStream = httpUrlConnection.inputStream
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()
        var line: String? = bufferReader.readLine()
        while (line != null) {
            builder.append(line)
            line = bufferReader.readLine()
        }
        bufferReader.close()
        httpUrlConnection.disconnect()
        return builder.toString()
    }

    fun parseJsonToMovieObject(jsonObject: JSONObject): Movie = Movie.MovieBuilder()
        .id(jsonObject.getInt(MovieEntry.ID))
        .backDropPathUrl(jsonObject.getString(MovieEntry.BACKDROP_PATH))
        .posterPathUrl(jsonObject.getString(MovieEntry.POSTER_PATH))
        .title(jsonObject.getString(MovieEntry.TITLE))
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

    fun parsenJsonToGenresObject(jsonObject: JSONObject): Genres =
        Genres(jsonObject.getInt(GenresEntry.ID), jsonObject.getString(GenresEntry.NAME))

    fun parseJsonToGenres(string: String): Movie {
        val genresList = mutableListOf<Genres>()
        val jsonObject = JSONObject(string)
        val jsonArray = JSONObject(string).getJSONArray(MovieEntry.GENRES)
        for (i in 0 until jsonArray.length()) {
            val genres = parsenJsonToGenresObject(jsonArray.getJSONObject(i))
            genresList.add(genres)
        }

        return Movie.MovieBuilder()
            .title(jsonObject.getString(MovieEntry.TITLE))
            .backDropPathUrl(jsonObject.getString(MovieEntry.BACKDROP_PATH))
            .posterPathUrl(jsonObject.getString(MovieEntry.POSTER_PATH))
            .overView(jsonObject.getString(MovieEntry.OVERVIEW))
            .voteAverage(jsonObject.getDouble(MovieEntry.VOTE_AVERAGE))
            .id(jsonObject.getInt(MovieEntry.ID))
            .genresList(genresList)
            .bind()
    }

    companion object{
        private const val TIME_OUT = 15000
        private const val GET = "GET"
    }
}
