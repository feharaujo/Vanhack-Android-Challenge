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
data class Customer(
        @field: JsonProperty("id")
        val id: Int? = null,

        @field:JsonProperty("email")
        val email: String? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("address")
        val address: String? = null,

        @field:JsonProperty("creation")
        val creation: String? = null,

        @field:JsonProperty("password")
        val password: String? = null
) : Parcelable