package com.uma.retrofitwithrxjava.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uma.retrofitwithrxjava.R
import com.uma.retrofitwithrxjava.repository.data.City
import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_item.view.txtCityId
import kotlinx.android.synthetic.main.list_item.view.txtCityName
import kotlinx.android.synthetic.main.list_item.view.txtDisplayName

/**
 * Author     : Umapathi
 * Email      : umapathir2@gmail.com
 * Github     : https://github.com/umapathi2128
 * Created on : 2020-10-09.
 */

class MainAdapter() : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    var list = ArrayList<City>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    class MyViewHolder(var v : View) : RecyclerView.ViewHolder(v) {
        fun onBind(cityResponse: City){
            v.txtCityId.text = cityResponse.id
            v.txtCityName.text = cityResponse.cityname
            v.txtDisplayName.text = cityResponse.display_name

        }
    }

    fun addItems(cityList :ArrayList<City>){
        list.apply {
            clear()
        }

        list = cityList
        notifyDataSetChanged()
    }
}