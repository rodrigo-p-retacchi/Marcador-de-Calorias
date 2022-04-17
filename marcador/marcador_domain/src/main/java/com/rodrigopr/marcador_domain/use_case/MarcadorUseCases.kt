package com.rodrigopr.marcador_domain.use_case

data class MarcadorUseCases(
    val marcadorFood: MarcadorFood,
    val searchFood: SearchFood,
    val getFoodsForDate: GetFoodForDates,
    val deleteMarcadaFood: DeleteMarcadorFood,
    val calculateMealNutrients: CalculateMealNutrients
)