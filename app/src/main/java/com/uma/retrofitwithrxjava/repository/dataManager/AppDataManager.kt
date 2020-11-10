package com.uma.retrofitwithrxjava.repository.dataManager

import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import com.uma.retrofitwithrxjava.repository.network.ApiHelper
import io.reactivex.rxjava3.core.Observable

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

class AppDataManager(private var apiHelper : ApiHelper = ApiHelper()) : DataManager {


    override fun getCityList(airlineid: String): Observable<CityListResponse> {
        return apiHelper.getCityList(airlineid)
    }
}