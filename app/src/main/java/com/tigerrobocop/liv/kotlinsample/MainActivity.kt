package com.tigerrobocop.liv.kotlinsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.tigerrobocop.liv.kotlinsample.Model.XKCD
import com.tigerrobocop.liv.kotlinsample.ViewModel.XKCDViewModel

class MainActivity : AppCompatActivity() {

    private var viewModel: XKCDViewModel? = null

    var img_alt: String? = null
    var mImg: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImg = findViewById<View>(R.id.img_xkcd) as ImageView

        viewModel = ViewModelProviders.of(this).get(XKCDViewModel::class.java!!)
        viewModel?.init()

        subscribeUI(viewModel)

    }

    fun subscribeUI(viewModel : XKCDViewModel?){

        viewModel?.getXKCD()?.observe(this, Observer<XKCD> { xkcd ->
            if (xkcd != null) {
                //  mTxt.setText(xkcd.title);
                Log.d(MainActivity::class.java.simpleName, xkcd.title)
                img_alt = xkcd.alt

                Picasso.with(applicationContext).load(xkcd.img).into(mImg)

                val toast = Toast.makeText(applicationContext, xkcd.title, Toast.LENGTH_SHORT)
                toast.show()
            }
        })
    }
}
