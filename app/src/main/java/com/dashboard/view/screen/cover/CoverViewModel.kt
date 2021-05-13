package com.dashboard.view.screen.cover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dashboard.configurations.TaskExecutor
import com.dashboard.model.domain.Article
import com.dashboard.model.domain.Category
import com.dashboard.model.domain.Source
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.onFailure
import com.dashboard.repository.remote.onSuccess

class CoverViewModel(private val repository: DashboardRemoteRepository, private val task: TaskExecutor): ViewModel() {
   private val _stateArticles = MutableLiveData<CoverState>()
   val stateArticles = _stateArticles as LiveData<CoverState>

   fun articles() = task.launch {
       val result = task.async { repository.headlines() }
       val categories = task.async { repository.categories() }
       val sources = task.async { repository.sources() }

       result?.onSuccess {
           if(it.articles.isEmpty()) {
               _stateArticles.value = CoverState.Empty
           } else {
               categories?.onSuccess { categoriesResult ->
                   sources?.onSuccess { sourcesResult ->
                       _stateArticles.value = CoverState.Data(
                           it.articles,
                           sourcesResult.sources,
                           categoriesResult.categories
                       )
                   }?.onFailure {
                       _stateArticles.value = CoverState.Error(it?.message?:"")
                   }
               }?.onFailure {
                   _stateArticles.value = CoverState.Error(it?.message?:"")
               }
           }
       }?.onFailure {
           _stateArticles.value = CoverState.Error(it?.message?:"")
       }
   }
}

sealed class CoverState {
    object Empty : CoverState()
    object Load : CoverState()
    class Error(val message: String) : CoverState()
    class Data(val articles: List<Article>, val sources: List<Source>, val categories: List<Category>) : CoverState()
}