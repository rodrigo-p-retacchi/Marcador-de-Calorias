package com.rodrigopr.marcadorcalorias.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.rodrigopr.core.data.preferences.DefaultPreferences
import com.rodrigopr.core.domain.preferences.Preferences
import com.rodrigopr.core.domain.use_case.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSharePreferences(
        app:Application
    ): SharedPreferences{
        return app.getSharedPreferences("shared_pref",MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences{
        return DefaultPreferences(sharedPreferences)
    }
    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }

}