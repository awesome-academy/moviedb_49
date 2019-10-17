package com.sun_asterisk.moviedb_49.utils

import androidx.annotation.StringDef

@StringDef(Category.POPULAR, Category.UP_COMING, Category.NOW_PLAYING, Category.TOP_RATE)
annotation class Category {
    companion object {
        const val POPULAR = "popular"
        const val UP_COMING = "up coming"
        const val NOW_PLAYING = "now playing"
        const val TOP_RATE = "top rate"
    }
}
