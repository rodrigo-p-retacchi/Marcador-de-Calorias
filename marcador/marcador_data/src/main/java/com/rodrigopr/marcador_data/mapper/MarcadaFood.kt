package com.rodrigopr.marcador_data.mapper

import com.rodrigopr.marcador_data.local.entity.MarcadorFootEntity
import com.rodrigopr.marcador_domain.model.MarcadaFood
import com.rodrigopr.marcador_domain.model.MealType
import java.time.LocalDate

fun MarcadorFootEntity.toMarcadorFood(): MarcadaFood{
    return MarcadaFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id

    )
}

fun MarcadaFood.toMarcadaFoodEntity(): MarcadorFootEntity{
    return MarcadorFootEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id
    )
}