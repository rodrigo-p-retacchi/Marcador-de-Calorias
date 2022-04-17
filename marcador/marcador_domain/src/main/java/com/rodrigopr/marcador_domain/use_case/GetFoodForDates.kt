package com.rodrigopr.marcador_domain.use_case

import com.rodrigopr.marcador_domain.model.MarcadaFood
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodForDates(
    private val repository: MarcadorRepository
) {
     operator fun invoke(
        date:LocalDate
    ):Flow<List<MarcadaFood>>
    {
       return repository.getFoodsForDate(date)
    }
}