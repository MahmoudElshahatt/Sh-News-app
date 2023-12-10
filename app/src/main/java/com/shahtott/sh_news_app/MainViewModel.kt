package com.shahtott.sh_news_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahtott.sh_news_app.domain.useCase.app_entry.AppEntryUseCase
import com.shahtott.sh_news_app.ui.presentation.navgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Routes.AppStartingNavigation.route)
        private set

    init {
        appEntryUseCase.getAppEntryUseCase().onEach {
            startDestination = when (it) {
                true -> {
                    Routes.MainNavigation.route
                }
                false -> {
                    Routes.AppStartingNavigation.route
                }
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}