package com.tigerrobocop.liv.kotlinsample.Repository.API

import com.tigerrobocop.liv.kotlinsample.Model.XKCD
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Livia on 06/01/2018.
 */
interface Service {

    @GET("info.0.json")
    fun getXKCD(): Call<XKCD>

    companion object Factory {
        fun create(): Service {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://xkcd.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    // talvez add adapter factory tbm. tem no tutorial mas nao no aoo original
                    .build()

            return retrofit.create(Service::class.java)
        }
    }
}