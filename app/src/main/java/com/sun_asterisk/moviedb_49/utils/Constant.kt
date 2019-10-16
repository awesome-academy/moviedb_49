package com.sun_asterisk.moviedb_49.utils

import com.sun_asterisk.moviedb_49.BuildConfig

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w94_and_h141_bestv2/"
    const val BASE_LANGUAGE = "&language=en-US"
    const val BASE_PAGE = "&page="
    const val BASE_API_KEY = "api_key=" + BuildConfig.API_KEY
    // Categories movie
    const val MOVIE_TOP_RATE = "movie/top_rated?"
    const val MOVIE_UP_COMING = "movie/upcoming?"
    const val MOVIE_POPULAR = "movie/popular?"
    const val MOVIE_NOW_PLAYING = "movie/now_playing?"
    // Messenger
    const val MESSENGER = "Result is null"
}
