package com.example.simplecarssalesapp.data.network

import okhttp3.Interceptor
import okhttp3.Response
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()){

        }
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {


        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            return true

        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected

        }

    }
}