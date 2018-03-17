package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

/**
 * Created by felipearaujo on 17/03/18.
 */
@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
class SimpleCustomer (
        @field:JsonProperty("email")
        val email: String? = null,

        @field:JsonProperty("password")
        val password: String? = null
): Parcelable