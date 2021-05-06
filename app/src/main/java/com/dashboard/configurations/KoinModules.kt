package com.dashboard.configurations

import androidx.lifecycle.viewModelScope
import com.dashboard.repository.implementation.DashboardRemoteRepositoryImplementation
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.DashboardGateway
import com.dashboard.view.screen.search.SearchViewModel
import com.dashboard.view.screen.cover.CoverViewModel
import com.dashboard.model.usecase.MainPageUseCase
import com.dashboard.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

var retrofitModule = module {
    factory<Retrofit> {
        val host = if(BuildConfig.DEBUG) {
            "https://sheltered-dawn-75915.herokuapp.com/"
        } else {
            "https://soccer-news-gatway.herokuapp.com/"
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
                    .addInterceptor(object: Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            return chain.proceed(chain.request())
                        }
                    })
                    .hostnameVerifier { hostname, _ ->
                        host.contains(hostname) || BuildConfig.DEBUG
                    }
                    .build()
            )
            .build()
    }
    factory<DashboardGateway> {
        get<Retrofit>().create(DashboardGateway::class.java)
    }
}

var viewModelModule = module {
    viewModel {
        val task = TaskExecutor()
        val coverViewModel = CoverViewModel(
            repository = get(),
            task = task
        )
        task.with(coverViewModel.viewModelScope)

        coverViewModel
    }

    viewModel {
        val task = TaskExecutor()
        val searchViewModel = SearchViewModel(
            repository = get(),
            task = task
        )
        task.with(searchViewModel.viewModelScope)

        searchViewModel
    }
}

var repositoryModule = module {
    factory<DashboardRemoteRepository> {
        DashboardRemoteRepositoryImplementation(get())
    }
}

var useCaseModule = module {
    factory {
        MainPageUseCase(get())
    }
}