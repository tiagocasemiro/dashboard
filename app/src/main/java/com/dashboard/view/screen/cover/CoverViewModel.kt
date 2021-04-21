package com.dashboard.view.screen.cover

import androidx.lifecycle.ViewModel
import com.dashboard.configurations.TaskExecutor
import com.dashboard.model.domain.Article
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.onFailure
import com.dashboard.repository.remote.onSuccess

class CoverViewModel(private val repository: DashboardRemoteRepository, private val task: TaskExecutor): ViewModel() {

   fun article(onResult: (CoverState) -> Unit) = task.exec {
       val result = task.async { repository.headlines() }
       result?.onSuccess {
           if(it.articles.isEmpty())
                onResult(CoverState.Empty)
           else
                onResult(CoverState.Data(it.articles))
       }?.onFailure {
           onResult(CoverState.Error(it?.message?:""))
       }
   }
}

sealed class CoverState {
    object Empty : CoverState()
    object Load : CoverState()
    class Error(val message: String) : CoverState()
    class Data(val articles: List<Article>) : CoverState()
}