package com.rodrigopr.marcador_domain.use_case

import com.rodrigopr.marcador_domain.model.DetectableFood
import com.rodrigopr.marcador_domain.model.MarcadaFood
import com.rodrigopr.marcador_domain.model.MealType
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class MarcadorFood(
    private val repository: MarcadorRepository
) {
    suspend operator fun invoke(
        food: DetectableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    )
    {
        repository.insertMarcadaFood(
            MarcadaFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt() ,
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt() ,
                fat = ((food.fatPer100g / 100f) * amount).roundToInt() ,
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt() ,
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date,
            )
        )

    }
}