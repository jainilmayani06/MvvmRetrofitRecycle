package com.example.mvvmretrofitrecycle.retrofit

import com.example.mvvmretrofitrecycle.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {


    @GET("v3.1/all")
    fun getCountryList(): Call<List<CountryModel>>
}