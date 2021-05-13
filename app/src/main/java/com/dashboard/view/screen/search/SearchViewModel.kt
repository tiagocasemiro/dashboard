package com.dashboard.view.screen.search

import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.onFailure
import com.dashboard.repository.remote.onSuccess
import com.dashboard.configurations.TaskExecutor
import com.dashboard.model.domain.Article
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel(private val repository: DashboardRemoteRepository, private val task: TaskExecutor): ViewModel() {
    val stateArticles = MutableLiveData<SearchState>()

    fun searchBy(term: String? = null) = task.launch {
        val result = task.async { repository.everything(term) }

        result?.onSuccess {
            if(it.totalResults > 0) {
                stateArticles.value = SearchState.Data(it.articles)
            } else {
                stateArticles.value = SearchState.Empty
            }
        }?.onFailure {
            stateArticles.value = SearchState.Error(it?.message?:"")
        }
    }
}

sealed class SearchState {
    object Empty : SearchState()
    object Load : SearchState()
    class Error(val message: String) : SearchState()
    class Data(val articles: List<Article>) : SearchState()
}