package com.sun_asterisk.moviedb_49.data.source.remote

import android.graphics.Bitmap

interface OnFetchImageListener {
    fun loadedImage(bitmap: Bitmap)

    fun onFail(exception: Exception)
}
