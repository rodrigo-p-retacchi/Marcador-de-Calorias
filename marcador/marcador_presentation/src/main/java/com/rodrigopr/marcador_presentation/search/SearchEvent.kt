package com.rodrigopr.marcador_presentation.search

import com.rodrigopr.marcador_domain.model.DetectableFood
import com.rodrigopr.marcador_domain.model.MealType
import java.time.LocalDate

sealed class SearchEvent {
    data class OnQueryChange(val query: String) : SearchEvent()
    object OnSearch : SearchEvent()
    data class OnToggleTrackableFood(val food: DetectableFood) : SearchEvent()
    data class OnAmountForFoodChange(
        val food: DetectableFood,
        val amount: String
    ) : SearchEvent()
    data class OnTrackFoodClick(
        val food: DetectableFood,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}