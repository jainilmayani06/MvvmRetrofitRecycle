package com.example.mvvmretrofitrecycle.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitrecycle.data.CountryModel
import com.example.mvvmretrofitrecycle.retrofit.RetroInstanse
import com.example.mvvmretrofitrecycle.retrofit.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivityViewModel : ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<CountryModel>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<CountryModel>> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstanse.getRetroInstance();
        val retroService  = retroInstance.create(RetroService::class.java)
        val call  = retroService.getCountryList()
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }
}