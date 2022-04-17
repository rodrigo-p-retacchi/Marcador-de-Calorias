package com.rodrigopr.marcador_domain.repository

import com.rodrigopr.marcador_domain.model.DetectableFood
import com.rodrigopr.marcador_domain.model.MarcadaFood
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow

interface MarcadorRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ):Result<List<DetectableFood>>

    suspend fun insertMarcadaFood(food: MarcadaFood)

    suspend fun deleteMarcadaFood(food: MarcadaFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<MarcadaFood>>
}