package com.dashboard.view.screen.cover

import androidx.lifecycle.ViewModel
import com.dashboard.configurations.TaskExecutor
import com.dashboard.model.domain.Article
import com.dashboard.repository.DashboardRemoteRepository
import com.dashboard.repository.remote.onFailure
import com.dashboard.repository.remote.onSuccess

class CoverViewModel(private val repository: DashboardRemoteRepository, private val task: TaskExecutor): ViewModel() {

   fun article(onSuccess: (List<Article>) -> Unit, onError: (String?) -> Unit) = task.exec {
       val result = task.async { repository.headlines() }
       result?.onSuccess {
           onSuccess(it.articles)
       }?.onFailure {
           onError(it?.message)
       }
   }
}