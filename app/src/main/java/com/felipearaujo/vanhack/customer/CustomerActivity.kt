package com.felipearaujo.vanhack.customer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.felipearaujo.data.CODE_CREATE_ACC
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.base.BaseActivity
import com.felipearaujo.vanhack.createacc.CreateAccountActivity
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import com.felipearaujo.vanhack.helper.EventTypeEnum
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_CREATE_ACC && resultCode == Activity.RESULT_OK) {
            val message = getGeneralMessage(EventTypeEnum.ACCOUNT_CREATED_SUCCESS)
            Snackbar.make(root_container, message, Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun openCreateAccScreen() {
        startActivityForResult(intentFor<CreateAccountActivity>(), CODE_CREATE_ACC)
    }

    override fun openDashboardScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorTypeEnum: ErrorTypeEnum) {
        val message = getErrorMessage(errorTypeEnum)
        Snackbar.make(root_container, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showLoginInputContainer() {
        form_container.visibility = View.VISIBLE
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoginInputContainer() {
        form_container.visibility = View.GONE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

}
