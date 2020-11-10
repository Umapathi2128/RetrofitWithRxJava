package com.uma.retrofitwithrxjava.repository.network

import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

interface ApiService {

    @FormUrlEncoded
    @POST("CityList")
    fun getCityList(@Field("airlineid") airlineid : String) : Observable<CityListResponse>

}