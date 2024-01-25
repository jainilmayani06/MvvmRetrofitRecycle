package com.example.mvvmretrofitrecycle.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstanse {

    companion object{
        val BASE_URL = "https://restcountries.com/"



            fun getRetroInstance(): Retrofit {
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
    }
}