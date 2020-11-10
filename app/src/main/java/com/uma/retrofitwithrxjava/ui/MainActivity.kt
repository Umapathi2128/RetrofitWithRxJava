package com.uma.retrofitwithrxjava.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.uma.retrofitwithrxjava.R
import com.uma.retrofitwithrxjava.repository.data.City
import com.uma.retrofitwithrxjava.repository.data.CityListResponse
import com.uma.retrofitwithrxjava.repository.dataManager.AppDataManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setUpUI()
        viewModel.getCityResponse("7")
//        viewModel.getCityDetails("7")
    }

    private fun setUpUI() {
        adapter = MainAdapter()
        recycler.apply {
            layoutManager =TopDissolveLayoutManager()
            adapter = this@MainActivity.adapter
        }
//        recycler.layoutManager = TopDissolveLayoutManager()

    }

    private fun setupViewModel() {
        val factory = MainViewModelFactory(AppDataManager(), this)
         viewModel  = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun onSucces(response: CityListResponse) {
        runOnUiThread {
            recycler.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            adapter.addItems(response.data as ArrayList<City>)
        }
    }

    override fun onError(error: String) {
        runOnUiThread {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}