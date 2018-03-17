package com.felipearaujo.data.common

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by felipearaujo on 17/03/18.
 */
interface BaseRepository {

    /**
     * Check connection
     */
    private fun isNetworkConnected(appContext: Context): Boolean {
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

}