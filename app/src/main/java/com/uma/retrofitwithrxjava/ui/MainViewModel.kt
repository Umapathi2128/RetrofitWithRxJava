package com.uma.retrofitwithrxjava.ui

import androidx.lifecycle.ViewModel
import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import com.uma.retrofitwithrxjava.repository.dataManager.AppDataManager
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */
class MainViewModel(var appDataManager: AppDataManager,var mainView: MainView ) : ViewModel() {

    var id : String = ""
    var name : String = ""
    var displayName : String = ""


    fun getCityDetails(airlineId: String) {
         var response : CityListResponse? = null
        appDataManager.getCityList(airlineId).subscribe {
            response = it
            mainView.onSucces(it)
        }
//        return response
    }

    fun getCityResponse(airlineId: String){

        appDataManager.getCityList(airlineId).subscribe(object : Observer<CityListResponse>{
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: CityListResponse?) {
                t?.let { mainView.onSucces(it) }
            }

            override fun onError(e: Throwable?) {
                mainView.onError(e?.message.toString())
            }

            override fun onComplete() {
            }

        })
    }
}