package com.uma.retrofitwithrxjava.repository.network

import io.reactivex.rxjava3.plugins.RxJavaPlugins
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

open class RetrofitBuilder : BaseOkHttp() {

    private val BASEURL = "https://qa-new.skyhop.io/index.php/apiv7/"
    private val BASEURL2 = "https://staging-new.skyhop.io/appservice/webservicesV7/"
    private val rxAdapter = RxJava3CallAdapterFactory.create()

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
//            .interceptors().add(interceptor)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    var retrofit = Retrofit.Builder()
        .baseUrl(BASEURL2)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(rxAdapter)
        .client(provideOKHttpClient())
        .build()
}