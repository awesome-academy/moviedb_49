package com.sun_asterisk.moviedb_49.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: MutableList<T>)

    fun onFail(exception: Exception)
}
