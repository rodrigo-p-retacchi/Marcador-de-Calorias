package com.rodrigopr.marcador_data.repository

import com.rodrigopr.marcador_data.local.MarcadorDao
import com.rodrigopr.marcador_data.mapper.toDetectableFood
import com.rodrigopr.marcador_data.mapper.toMarcadaFoodEntity
import com.rodrigopr.marcador_data.mapper.toMarcadorFood
import com.rodrigopr.marcador_data.remote.FoodApi
import com.rodrigopr.marcador_domain.model.DetectableFood
import com.rodrigopr.marcador_domain.model.MarcadaFood
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import java.time.LocalDate

class RepositoryImpl (
    private val dao: MarcadorDao,
    private val api: FoodApi
    ) : MarcadorRepository{
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<DetectableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products
                    .filter {
                        val calculatedCalories =
                            it.nutriments.carbohydrates100g * 4f +
                                    it.nutriments.proteins100g * 4f +
                                    it.nutriments.fat100g * 9f
                        val lowerBound = calculatedCalories * 0.99f
                        val upperBound = calculatedCalories * 1.01f
                        it.nutriments.energyKcal100g in (lowerBound..upperBound)
                    }
                    .mapNotNull { it.toDetectableFood() }
            )
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun insertMarcadaFood(food: MarcadaFood) {
        dao.insertMarcadorFood(food.toMarcadaFoodEntity())
    }

    override suspend fun deleteMarcadaFood(food: MarcadaFood) {
        dao.deleteMarcadadorFood(food.toMarcadaFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<MarcadaFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map {entities ->
            entities.map { it.toMarcadorFood() }
        }
    }

}