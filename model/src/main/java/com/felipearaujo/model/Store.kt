package com.felipearaujo.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Store(

	@field:JsonProperty("address")
	val address: String? = null,

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("cousineId")
	val cousineId: Int? = null
) : Parcelable