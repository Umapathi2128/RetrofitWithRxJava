package com.uma.retrofitwithrxjava.repository.data


/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

data class CityListResponse(val data: List<City>?,
                            val message: String = "",
                            val status: String = "") : BaseResponse() {
    override val apiStatus: String
        get() = status
    override val apiMessage: String
        get() = message

}

data class CompanylistItem(val companyid: String = "",
                           val companyname: String = "",
                           val dispatch_phone: String = "")

data class City(val citycode: String = "",
                val companylist: List<CompanylistItem>?,
                val cityname: String = "",
                val display_name: String = "",
                val id: String = "")