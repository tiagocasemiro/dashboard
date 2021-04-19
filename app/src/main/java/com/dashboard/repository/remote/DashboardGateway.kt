package com.dashboard.repository.remote

import com.dashboard.model.domain.Articles
import com.dashboard.model.domain.Categories
import com.dashboard.model.domain.Sources
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DashboardGateway {
    @GET("/headlines")
    suspend fun headlines(): Response<Articles>

    @GET("/headlines/source/{source}")
    suspend fun headlines(@Path("source") source: String): Response<Articles>

    @GET("/sources")
    suspend fun sources(): Response<Sources>

    @GET("/everything")
    suspend fun everything(@Query("query") query: String? = null): Response<Articles>

    @GET("/category/{category}")
    suspend fun category(@Path("category") category: String): Response<Articles>

    @GET("/categories")
    suspend fun categories(): Response<Categories>

    @GET("/nexo")
    suspend fun nexo(): Response<Articles>

    @GET("/the-intercept-brazil")
    suspend fun theInterceptBrazil(): Response<Articles>

    @GET("/tech-mundo")
    suspend fun techMundo(): Response<Articles>
}