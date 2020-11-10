package com.uma.retrofitwithrxjava.repository.network

import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import io.reactivex.rxjava3.core.Observable


/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */
class ApiHelper : RetrofitBuilder(){

    private fun getApiService()  = retrofit.create(ApiService::class.java)

    fun getCityList(airelineId : String) : Observable<CityListResponse>{
        return getApiService().getCityList(airelineId)
    }
}