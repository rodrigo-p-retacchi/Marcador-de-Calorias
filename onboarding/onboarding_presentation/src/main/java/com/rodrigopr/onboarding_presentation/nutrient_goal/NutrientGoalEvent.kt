package com.rodrigopr.onboarding_presentation.nutrient_goal

sealed class NutrientGoalEvent{
    data class onCarbRatioEnter(val ratio:String): NutrientGoalEvent()
    data class onProteinRatioEnter(val ratio:String): NutrientGoalEvent()
    data class onFatbRatioEnter(val ratio:String): NutrientGoalEvent()
    object OnNextClick: NutrientGoalEvent()
}
