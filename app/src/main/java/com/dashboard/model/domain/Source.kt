package com.dashboard.model.domain

import com.google.gson.annotations.SerializedName

data class Source (
	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String? = null,
	@SerializedName("url") val url : String? = null,
	@SerializedName("category") val category : String? = null,
	@SerializedName("language") val language : String? = null,
	@SerializedName("country") val country : String? = null
)

data class Sources (
	@SerializedName("status") val status : String,
	@SerializedName("sources") val sources : List<Source>
)