package com.rodrigopr.marcador_presentation.marcador_overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigopr.core.domain.preferences.Preferences
import com.rodrigopr.core.util.UiEvent
import com.rodrigopr.marcador_domain.use_case.MarcadorUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarcadorOverviewViewModel @Inject constructor(
    preferences: Preferences,
    private val marcadorUseCases: MarcadorUseCases
) : ViewModel(){
    var state by mutableStateOf(MarcadorOverviewState())
        private set
    private var getFoodsForDateJob : Job? = null
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        refreshFoods()
        preferences.saveShouldShowOnboarding(false)
    }


    fun onEvent(event: MarcadorOverviewEvent){
        when(event){
            is MarcadorOverviewEvent.OnDeleteMarcadaFoodClick -> {
                    viewModelScope.launch {
                        marcadorUseCases.deleteMarcadaFood(event.marcadafood)
                        refreshFoods()
                    }
            }
            is MarcadorOverviewEvent.OnNextDayClick -> {
                    state = state.copy(
                        date = state.date.plusDays(1)
                    )
                refreshFoods()
            }
            is MarcadorOverviewEvent.OnPreviousDayClick -> {
                    state = state.copy(
                        date = state.date.minusDays(1)
                    )
                refreshFoods()
            }
            is MarcadorOverviewEvent.OnToggleMealClick -> {
                    state = state.copy(
                        meals = state.meals.map {
                            if (it.name == event.meal.name){
                                it.copy(
                                    isExpanded = !it.isExpanded
                                )
                            }else it
                        }
                    )
            }
        }
    }

    private fun refreshFoods() {
         getFoodsForDateJob?.cancel()
         getFoodsForDateJob =    marcadorUseCases.getFoodsForDate(state.date)
                .onEach { foods ->
                    val nutrientsResult  = marcadorUseCases.calculateMealNutrients(foods)
                    state = state.copy(
                        totalCarbs = nutrientsResult.totalCarbs,
                        totalProtein = nutrientsResult.totalProtein,
                        totalFat = nutrientsResult.totalFat,
                        totalCalories = nutrientsResult.caloriesGoal,
                        carbsGoal = nutrientsResult.carbsGoal,
                        proteinGoal = nutrientsResult.proteinGoal,
                        fatGoal = nutrientsResult.fatGoal,
                        caloriesGoal = nutrientsResult.caloriesGoal,
                        marcadasFoods = foods,
                        meals = state.meals.map {
                            val nutrientsMeal =
                                nutrientsResult.mealNutrients[it.mealType]
                                    ?: return@map it.copy(
                                        carbs = 0,
                                        protein = 0,
                                        fat = 0,
                                        calories = 0
                                    )
                            it.copy(
                                carbs = nutrientsMeal.carbs,
                                protein = nutrientsMeal.protein,
                                fat = nutrientsMeal.fat,
                                calories = nutrientsMeal.calories
                            )
                        }
                    )
                }
                .launchIn(viewModelScope)
    }
}