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
data class Order(
        @field: JsonProperty("id")
        val id: Int? = null,

        @field:JsonProperty("date")
        val date: String? = null,

        @field:JsonProperty("customerId")
        val customerId: Int? = null,

        @field:JsonProperty("deliveryAddress")
        val deliveryAddress: String? = null,

        @field:JsonProperty("contact")
        val contact: String? = null,

        @field:JsonProperty("storeId")
        val storeId: Int? = null,

        @field:JsonProperty("total")
        val total: Double? = null,

        @field:JsonProperty("status")
        val status: String? = null,

        @field:JsonProperty("lastUpdate")
        val lastUpdate: String? = null,

        @field:JsonProperty("orderItems")
        val orderItems: List<OrderItem>? = null

) : Parcelable