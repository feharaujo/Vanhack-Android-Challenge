package com.felipearaujo.vanhack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipearaujo.vanhack.customer.CustomerActivity
import org.jetbrains.anko.intentFor

/**
 * Created by felipearaujo on 17/03/18.
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(intentFor<CustomerActivity>())
        finish()
    }

}