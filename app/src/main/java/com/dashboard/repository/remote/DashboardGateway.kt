package com.dashboard.repository.remote

import com.dashboard.model.domain.Articles
import com.dashboard.model.domain.Sources
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DashboardGateway {
    @GET("/headlines")
    fun headlines(): Response<Articles>

    @GET("/headlines/source/{source}")
    fun headlines(@Path("source") source: String): Response<Articles>

    @GET("/sources")
    fun sources(): Response<Sources>

    @GET("/everything")
    fun everything(@Query("query") query: String? = null): Response<Articles>

    @GET("/category/{category}")
    fun category(@Path("category") category: String): Response<Articles>

    @GET("/categories")
    fun categories(): Response<List<String>>

    @GET("/nexo")
    fun nexo(): Response<Articles>

    @GET("/the-intercept-brazil")
    fun theInterceptBrazil(): Response<Articles>

    @GET("/tech-mundo")
    fun techMundo(): Response<Articles>
}