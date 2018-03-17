package com.felipearaujo.vanhack.createacc

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.MenuItem
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.base.BaseActivity
import com.felipearaujo.vanhack.helper.ErrorType
import kotlinx.android.synthetic.main.activity_create_account.*
import javax.inject.Inject

class CreateAccountActivity : BaseActivity<CreateAccountContract.View, CreateAccountContract.Presenter>(), CreateAccountContract.View {

    @Inject
    override lateinit var presenter: CreateAccountContract.Presenter

    override fun initPresenter(): CreateAccountContract.Presenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bt_sign_up.setOnClickListener {
            sendFormData()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sendFormData() {
        val email = et_email.text.toString()
        val address = et_address.text.toString()
        val name = et_name.text.toString()
        val password = et_password.text.toString()

        presenter.submitAccountData(name, email, address, password)
    }

    override fun accountCreatedWithSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun accountCreationFailed(errorType: ErrorType) {
        val message = getErrorMessage(errorType)
        Snackbar.make(root_container, message, Snackbar.LENGTH_SHORT).show()
    }
}
