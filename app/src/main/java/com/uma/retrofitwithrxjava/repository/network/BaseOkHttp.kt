package com.uma.retrofitwithrxjava.repository.network

import android.os.AsyncTask
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */
open class BaseOkHttp  {
    val HTTP_CACHE_PATH = "http-cache"
    val CACHE_CONTROL = "Cache-Control"
    val PRAGMA = "Pragma"
    val NETWORK_CONNECTION_TIMEOUT = 120L

    /**
     * Provide OkHttpClient object with header
     */
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(provideBasicAuthInterceptor())
                .connectTimeout(NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS).build()
    }

    /**
     * Apply header to OkHttpClient chain request
     */
    private fun provideBasicAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()?.newBuilder()?.addHeader("X-API-KEY", "pilot_BQokikJOvBiI2HlWgH4olfQ2")?.build()
            chain.proceed(request!!)
        }
    }


}