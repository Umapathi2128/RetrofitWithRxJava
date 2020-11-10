package com.uma.retrofitwithrxjava.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uma.retrofitwithrxjava.repository.dataManager.AppDataManager
import java.lang.IllegalArgumentException
/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */
class MainViewModelFactory(var appDataManager: AppDataManager,var mainView: MainView) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(appDataManager,mainView) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}