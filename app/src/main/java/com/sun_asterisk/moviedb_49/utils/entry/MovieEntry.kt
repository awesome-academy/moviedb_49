package com.sun_asterisk.moviedb_49.utils.entry

import androidx.annotation.StringDef

@StringDef(
    MovieEntry.RESULTS,
    MovieEntry.ID,
    MovieEntry.POSTER_PATH,
    MovieEntry.BACKDROP_PATH,
    MovieEntry.OVERVIEW,
    MovieEntry.TITLE,
    MovieEntry.VOTE_AVERAGE,
    MovieEntry.GENRES
)
annotation class MovieEntry {
    companion object {
        const val RESULTS = "results"
        const val ID = "id"
        const val POSTER_PATH = "poster_path"
        const val BACKDROP_PATH = "backdrop_path"
        const val OVERVIEW = "overview"
        const val TITLE = "title"
        const val VOTE_AVERAGE = "vote_average"
        const val GENRES = "genres"
    }
}
