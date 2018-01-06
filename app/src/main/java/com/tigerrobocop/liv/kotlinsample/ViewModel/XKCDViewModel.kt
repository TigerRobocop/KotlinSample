package com.tigerrobocop.liv.kotlinsample.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.tigerrobocop.liv.kotlinsample.Model.XKCD
import com.tigerrobocop.liv.kotlinsample.Repository.XKCDRepository

/**
 * Created by Livia on 06/01/2018.
 */
class XKCDViewModel : ViewModel () {

    var mXKCD : LiveData<XKCD>? = null

    private val repo = XKCDRepository()

    fun init() {
        if (mXKCD != null) {
            return
        }

        mXKCD = repo.getXKCD()
    }

    fun getXKCD(): LiveData<XKCD>? {
        return mXKCD
    }

}