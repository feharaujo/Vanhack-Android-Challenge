package com.felipearaujo.vanhack.customer

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.base.BaseActivity
import com.felipearaujo.vanhack.createacc.CreateAccountActivity
import com.felipearaujo.vanhack.helper.ErrorType
import kotlinx.android.synthetic.main.activity_customer.*
import org.jetbrains.anko.intentFor
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

        bt_create_acc.setOnClickListener {
            presenter.createAcc()
        }

        bt_sign_in.setOnClickListener {
            presenter.doLogin(et_email.text.toString(), et_password.text.toString())
        }
    }

    override fun openCreateAccScreen() {
        startActivity(intentFor<CreateAccountActivity>())
    }

    override fun openDashboardScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorType: ErrorType) {
        val message = getErrorMessage(errorType)
        Snackbar.make(root_container, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showLoginInputContainer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
