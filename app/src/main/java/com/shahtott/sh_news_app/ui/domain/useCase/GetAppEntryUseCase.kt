package com.shahtott.sh_news_app.ui.domain.useCase

import com.shahtott.sh_news_app.ui.domain.repository.LocalUserRepository

class GetAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
    suspend operator fun invoke() = localUserRepository.getAppEntry()
}