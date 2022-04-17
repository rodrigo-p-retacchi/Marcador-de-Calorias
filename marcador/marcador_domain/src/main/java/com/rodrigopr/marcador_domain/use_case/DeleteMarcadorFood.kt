package com.rodrigopr.marcador_domain.use_case

import com.rodrigopr.marcador_domain.model.MarcadaFood
import com.rodrigopr.marcador_domain.repository.MarcadorRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteMarcadorFood(
    private val repository: MarcadorRepository
) {
    suspend operator fun invoke(
        marcadaFood: MarcadaFood
    ){
       return repository.deleteMarcadaFood(marcadaFood)
    }
}