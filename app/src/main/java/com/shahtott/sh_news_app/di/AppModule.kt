package com.shahtott.sh_news_app.di

import android.content.Context
import com.shahtott.sh_news_app.data.remote.api.NewsApi
import com.shahtott.sh_news_app.data.repositoryImpl.LocalUserRepositoryImpl
import com.shahtott.sh_news_app.data.repositoryImpl.NewsRepositoryImpl
import com.shahtott.sh_news_app.domain.repository.LocalUserRepository
import com.shahtott.sh_news_app.domain.repository.NewsRepository
import com.shahtott.sh_news_app.domain.useCase.app_entry.AppEntryUseCase
import com.shahtott.sh_news_app.domain.useCase.app_entry.GetAppEntryUseCase
import com.shahtott.sh_news_app.domain.useCase.app_entry.SaveAppEntryUseCase
import com.shahtott.sh_news_app.domain.useCase.news.GetNewsUseCase
import com.shahtott.sh_news_app.domain.useCase.news.NewsUseCases
import com.shahtott.sh_news_app.domain.useCase.news.SearchNewsUseCase
import com.shahtott.sh_news_app.ui.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi)
            : NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) = NewsUseCases(
        getNewsUseCase = GetNewsUseCase(newsRepository),
        searchNewsUseCase = SearchNewsUseCase(newsRepository)
    )

}