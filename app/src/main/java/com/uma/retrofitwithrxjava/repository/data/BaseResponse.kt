package com.uma.retrofitwithrxjava.repository.data


/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

abstract class BaseResponse {
    abstract val apiStatus: String
    abstract val apiMessage: String
}