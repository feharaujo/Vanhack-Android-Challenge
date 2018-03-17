package com.felipearaujo.vanhack.helper

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * Created by felipearaujo on 17/03/18.
 */
fun View.closeKeyboard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.getWindowToken(), 0)
}