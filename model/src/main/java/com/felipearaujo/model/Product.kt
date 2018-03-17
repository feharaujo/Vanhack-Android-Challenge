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
class Product(

        @field: JsonProperty("id")
        val id: Int? = null,

        @field:JsonProperty("storeId")
        val storeId: Int? = null,

        @field:JsonProperty("name")
        val name: String? = null,

        @field:JsonProperty("description")
        val description: String? = null,

        @field:JsonProperty("price")
        val price: Double? = null

) : Parcelable