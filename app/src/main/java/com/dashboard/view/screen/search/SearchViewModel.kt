package com.dashboard.view.screen.search

import androidx.lifecycle.ViewModel
import com.dashboard.configurations.TaskExecutor
import com.dashboard.repository.DashboardRemoteRepository

class SearchViewModel(private val repository: DashboardRemoteRepository, private val task: TaskExecutor): ViewModel() {
}