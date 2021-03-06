package com.dashboard.model.domain

import com.dashboard.repository.remote.DomainMapperResponse
import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("source") val source : Source? = null,
    @SerializedName("author") val author : String? = null,
    @SerializedName("title") val title : String? = null,
    @SerializedName("description") val description : String? = null,
    @SerializedName("url") val url : String? = null,
    @SerializedName("urlToImage") val urlToImage : String? = null,
    @SerializedName("publishedAt") val publishedAt : String? = null,
    @SerializedName("content") val content : String? = null
): DomainMapperResponse<Article> {
    override fun mapToDomain(): Article {
        return this
    }
}

data class Articles (
    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<Article>
): DomainMapperResponse<Articles> {
    override fun mapToDomain(): Articles {
        return this
    }
}