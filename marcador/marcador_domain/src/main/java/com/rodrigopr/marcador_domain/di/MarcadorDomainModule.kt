package com.rodrigopr.marcador_domain.di

import com.rodrigopr.core.domain.preferences.Preferences
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import com.rodrigopr.marcador_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MarcadorDomainModule {

    @ViewModelScoped
    @Provides
    fun provideMarcadorUseCases(
        repository: MarcadorRepository,
        preferences: Preferences
    ): MarcadorUseCases{
        return MarcadorUseCases(
            marcadorFood = MarcadorFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodForDates(repository),
            deleteMarcadaFood = DeleteMarcadorFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}