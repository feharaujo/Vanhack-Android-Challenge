package com.felipearaujo.vanhack.customer

import android.os.Bundle
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.base.BaseActivity
import javax.inject.Inject

class CustomerActivity : BaseActivity<CustomerContract.View, CustomerContract.Presenter>(), CustomerContract.View {

    @Inject
    override lateinit var presenter: CustomerContract.Presenter


    override fun initPresenter(): CustomerContract.Presenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

    }

    override fun openCreateAccScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openDashboardScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoginInputContainer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
