package com.tigerrobocop.liv.kotlinsample.util

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Livia on 06/01/2018.
 */
fun AppCompatActivity.showToast(msg : String?){

    val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
    toast.show()
}