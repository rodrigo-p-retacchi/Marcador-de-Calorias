package com.rodrigopr.marcador_presentation.marcador_overview

import com.rodrigopr.marcador_domain.model.MarcadaFood
import java.time.LocalDate

data class MarcadorOverviewState(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val marcadasFoods: List<MarcadaFood> = emptyList(),
    val meals: List<Meal> = defaultMeals
)
