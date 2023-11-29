package com.shahtott.sh_news_app

import androidx.lifecycle.ViewModel
import com.shahtott.sh_news_app.ui.domain.useCase.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
) : ViewModel() {

}