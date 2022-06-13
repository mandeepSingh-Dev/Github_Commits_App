package com.mandeep.github_commits_app.di

import android.content.Context
import com.mandeep.github_commits_app.MVVM.GitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import dagger.hilt.*
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val API = "https://api.github.com/"

    @Provides
    @Singleton
    fun getServicee(@ApplicationContext context: Context):GitService = Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build().create(GitService::class.java)
}