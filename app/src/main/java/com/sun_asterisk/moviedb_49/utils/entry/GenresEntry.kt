package com.sun_asterisk.moviedb_49.utils.entry

import androidx.annotation.StringDef

@StringDef(GenresEntry.GENRES_ID, GenresEntry.ID, GenresEntry.NAME)
annotation class GenresEntry {
    companion object {
        const val GENRES_ID = "genre_ids"
        const val ID = "id"
        const val NAME = "name"
    }
}
