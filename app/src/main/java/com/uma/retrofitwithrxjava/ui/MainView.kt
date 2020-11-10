package com.uma.retrofitwithrxjava.ui

import com.uma.retrofitwithrxjava.repository.data.CityListResponse

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

interface MainView {

    fun onSucces(response : CityListResponse)

    fun onError(error : String)


}