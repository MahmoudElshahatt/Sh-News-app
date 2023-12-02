package com.shahtott.sh_news_app.domain.useCase.app_entry

import com.shahtott.sh_news_app.domain.repository.LocalUserRepository

class SaveAppEntryUseCase(
    private val localUserRepository: LocalUserRepository
) {

    suspend operator fun invoke() {
        localUserRepository.saveAppEntry()
    }
}