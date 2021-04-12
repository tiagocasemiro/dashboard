package com.dashboard.repository.remote

interface DomainMapperResponse<T : Any> {
    fun mapToDomain(): T
}
