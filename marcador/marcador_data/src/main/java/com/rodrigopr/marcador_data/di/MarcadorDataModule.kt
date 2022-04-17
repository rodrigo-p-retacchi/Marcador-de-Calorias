package com.rodrigopr.marcador_data.di

import android.app.Application
import androidx.room.Room
import com.rodrigopr.marcador_data.local.MarcadorDataBase
import com.rodrigopr.marcador_data.remote.FoodApi
import com.rodrigopr.marcador_data.remote.FoodApi.Companion.BASE_URL
import com.rodrigopr.marcador_data.repository.RepositoryImpl
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarcadorDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }
    @Provides
    @Singleton
    fun providesFoodApi(client: OkHttpClient): FoodApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMarcadorDatabase(app:Application): MarcadorDataBase{
        return Room.databaseBuilder(
            app,
            MarcadorDataBase::class.java,
            "marcador_db"
        )
        .build()
    }

    @Provides
    @Singleton
    fun proviceMarcadorRepository(
        api: FoodApi,
        db: MarcadorDataBase
    ): MarcadorRepository{
        return RepositoryImpl(
            dao = db.dao,
            api = api
        )
    }


}