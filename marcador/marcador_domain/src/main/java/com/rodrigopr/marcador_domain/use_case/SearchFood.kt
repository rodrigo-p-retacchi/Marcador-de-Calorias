package com.rodrigopr.marcador_domain.use_case

import com.rodrigopr.marcador_domain.model.DetectableFood
import com.rodrigopr.marcador_domain.repository.MarcadorRepository

class SearchFood(
    private val repository: MarcadorRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<DetectableFood>>{
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(),page,pageSize)
    }
}