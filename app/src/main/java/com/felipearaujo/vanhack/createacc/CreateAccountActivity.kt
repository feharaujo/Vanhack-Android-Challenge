package com.felipearaujo.vanhack.createacc

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.MenuItem
import android.view.View
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.base.BaseActivity
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import com.felipearaujo.vanhack.helper.closeKeyboard
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
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showAccountCreationFailedMessage(errorTypeEnum: ErrorTypeEnum) {
        val message = getErrorMessage(errorTypeEnum)
        Snackbar.make(root_container, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showForm() {
        form_container.visibility = View.VISIBLE
    }

    override fun hideForm() {
        form_container.visibility = View.INVISIBLE
    }

    override fun closeKeyboard() {
        root_container.closeKeyboard()
    }
}
