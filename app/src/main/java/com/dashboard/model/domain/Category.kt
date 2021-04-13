package com.dashboard.model.domain

import com.dashboard.repository.remote.DomainMapperResponse
import com.google.gson.annotations.SerializedName

data class Category(@SerializedName("name") val name: String)

data class Categories(
    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("categories") val categories: List<Category>
): DomainMapperResponse<Categories>    {
    override fun mapToDomain(): Categories {
        return this
    }
}