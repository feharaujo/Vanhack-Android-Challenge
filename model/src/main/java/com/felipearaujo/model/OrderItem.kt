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
class OrderItem(

        @field: JsonProperty("id")
        val id: Int? = null,

        @field:JsonProperty("orderId")
        val orderId: Int? = null,

        @field:JsonProperty("productId")
        val productId: Int? = null,

        @field:JsonProperty("product")
        val product: Product? = null,

        @field:JsonProperty("price")
        val price: Double? = null,

        @field:JsonProperty("quantity")
        val quantity: Int? = null,

        @field:JsonProperty("total")
        val total: Double? = null

) : Parcelable