package com.dashboard.repository.implementation

import com.dashboard.model.domain.Articles
import com.dashboard.model.domain.Categories
import com.dashboard.model.domain.Sources
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.DashboardGateway
import com.dashboard.repository.remote.Result
import com.dashboard.repository.remote.extractData
import com.dashboard.repository.remote.fetchData

class DashboardRemoteRepositoryImplementation(private val dashboardGateway: DashboardGateway): DashboardRemoteRepository {
    override suspend fun headlines(): Result<Articles> {
        return fetchData {
            dashboardGateway.headlines().extractData()
        }
    }

    override suspend fun headlines(source: String): Result<Articles> {
        return fetchData {
            dashboardGateway.headlines(source).extractData()
        }
    }

    override suspend fun sources(): Result<Sources> {
        return fetchData {
            dashboardGateway.sources().extractData()
        }
    }

    override suspend fun everything(query: String?): Result<Articles> {
        return fetchData {
            dashboardGateway.everything(query).extractData()
        }
    }

    override suspend fun category(category: String): Result<Articles> {
        return fetchData {
            dashboardGateway.category(category).extractData()
        }
    }

    override suspend fun categories(): Result<Categories> {
        return fetchData {
            dashboardGateway.categories().extractData()
        }
    }

    override suspend fun nexo(): Result<Articles> {
        return fetchData {
            dashboardGateway.nexo().extractData()
        }
    }

    override suspend fun theInterceptBrazil(): Result<Articles> {
        return fetchData {
            dashboardGateway.theInterceptBrazil().extractData()
        }
    }

    override suspend fun techMundo(): Result<Articles> {
        return fetchData {
            dashboardGateway.techMundo().extractData()
        }
    }
}