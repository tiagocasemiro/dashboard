package com.dashboard.repository

import com.dashboard.model.domain.Articles
import com.dashboard.model.domain.Categories
import com.dashboard.model.domain.Sources
import com.dashboard.repository.remote.Result

interface DashboardRemoteRepository {
    suspend fun headlines(): Result<Articles>
    suspend fun headlines(source: String): Result<Articles>
    suspend fun sources(): Result<Sources>
    suspend fun everything(query: String? = null): Result<Articles>
    suspend fun category(category: String): Result<Articles>
    suspend fun categories(): Result<Categories>
    suspend fun nexo(): Result<Articles>
    suspend fun theInterceptBrazil(): Result<Articles>
    suspend fun techMundo(): Result<Articles>
}