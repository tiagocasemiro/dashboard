package com.dashboard.model.domain

import com.dashboard.repository.remote.DomainMapperResponse
import com.google.gson.annotations.SerializedName

data class Source (
	@SerializedName("id") val id : String? = null,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String? = null,
	@SerializedName("url") val url : String? = null,
	@SerializedName("category") val category : String? = null,
	@SerializedName("language") val language : String? = null,
	@SerializedName("country") val country : String? = null
): DomainMapperResponse<Source> {
	override fun mapToDomain(): Source {
		return this
	}
}

data class Sources (
	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("sources") val sources : List<Source>
): DomainMapperResponse<Sources> {
	override fun mapToDomain(): Sources {
		return this
	}
}