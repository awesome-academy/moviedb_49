package com.sun_asterisk.moviedb_49.data.source.remote.fetchdata

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import com.sun_asterisk.moviedb_49.data.source.remote.OnFetchImageListener
import com.sun_asterisk.moviedb_49.utils.Constant
import java.net.URL

class GetImageByAsyncTask(private var listener: OnFetchImageListener) :
    AsyncTask<String, Unit, Bitmap>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg imageUrl: String?): Bitmap? = downloadImage(imageUrl[0])

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        result?.let {
            listener.loadedImage(result)
        } ?: listener.onFail(exception ?: Exception(Constant.MESSENGER))
    }

    private fun downloadImage(url: String?): Bitmap? =
        try {
            val httpConnectionUrl = URL(url).openConnection()
            val inputStream = httpConnectionUrl.getInputStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (exception: Exception) {
            null
        }
}
