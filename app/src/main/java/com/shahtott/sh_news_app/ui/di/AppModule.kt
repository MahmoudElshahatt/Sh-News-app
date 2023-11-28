package com.shahtott.sh_news_app.ui.di

import android.content.Context
import com.shahtott.sh_news_app.ui.data.repositoryImpl.LocalUserRepositoryImpl
import com.shahtott.sh_news_app.ui.domain.repository.LocalUserRepository
import com.shahtott.sh_news_app.ui.domain.useCase.AppEntryUseCase
import com.shahtott.sh_news_app.ui.domain.useCase.GetAppEntryUseCase
import com.shahtott.sh_news_app.ui.domain.useCase.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserRepository(
        @ApplicationContext context: Context
    ): LocalUserRepository = LocalUserRepositoryImpl(context)


    @Provides
    @Singleton
    fun provideAppEntry(
        localUserRepository: LocalUserRepository
    ) = AppEntryUseCase(
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserRepository),
        getAppEntryUseCase = GetAppEntryUseCase(localUserRepository)
    )

}