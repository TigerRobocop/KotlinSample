package com.tigerrobocop.liv.kotlinsample.Repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.tigerrobocop.liv.kotlinsample.Model.XKCD
import com.tigerrobocop.liv.kotlinsample.Repository.API.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Livia on 06/01/2018.
 */
class XKCDRepository {

    val repo = Service.create()

    fun getXKCD(): LiveData<XKCD> {

        val data = MutableLiveData<XKCD>()

        repo.getXKCD().enqueue(object : Callback<XKCD>{

            override fun onResponse(call: Call<XKCD>?, response: Response<XKCD>?) {
                Log.d(XKCDRepository::class.java.simpleName, "onResponse:getXKCD - " + response?.body()?.link)
                data.value = response?.body()
            }

            override fun onFailure(call: Call<XKCD>?, t: Throwable?) {
                Log.d(XKCDRepository::class.java.simpleName, "onFailure:getXKCD")
            }
        })

        return data
    }
}