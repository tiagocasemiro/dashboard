package com.dashboard.configurations

import androidx.lifecycle.viewModelScope
import com.dashboard.BuildConfig
import com.dashboard.model.usecase.MainPageUseCase
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.implementation.DashboardRemoteRepositoryImplementation
import com.dashboard.repository.remote.DashboardGateway
import com.dashboard.view.screen.cover.CoverViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier

var retrofitModule = module {
    factory {
        val host = if(BuildConfig.DEBUG) {
            "https://sub.stg.m4u.com.br/salesman/"
        } else {
            "https://sub.m4u.com.br/salesman/"
        }
        Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .hostnameVerifier(HostnameVerifier { hostname, _ ->
                        host.contains(hostname) || BuildConfig.DEBUG
                    })
                    .build()
            )
            .build()
    }
    factory {
        get<Retrofit>().create(DashboardGateway::class.java)
    }
    factory {
        MainPageUseCase(get())
    }
    factory<DashboardRemoteRepository> {
        DashboardRemoteRepositoryImplementation(get())
    }
    factory {
        TaskExecutor()
    }
    viewModel {
        val task: TaskExecutor = get()
        val coverViewModel = CoverViewModel(
            repository = get(),
            task = task
        )
        task.with(coverViewModel.viewModelScope)

        coverViewModel
    }
}