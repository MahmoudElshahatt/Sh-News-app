package com.shahtott.sh_news_app.domain.useCase.app_entry

import com.shahtott.sh_news_app.domain.repository.LocalUserRepository

class GetAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {
     operator fun invoke() = localUserRepository.getAppEntry()
}