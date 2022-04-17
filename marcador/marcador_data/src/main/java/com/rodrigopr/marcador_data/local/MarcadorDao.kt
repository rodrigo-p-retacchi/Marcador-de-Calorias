package com.rodrigopr.marcador_data.local

import androidx.room.*
import com.rodrigopr.marcador_data.local.entity.MarcadorFootEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarcadorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarcadorFood(marcadorFoodEntity: MarcadorFootEntity)

    @Delete
    suspend fun deleteMarcadadorFood(mardadorFoodEntity: MarcadorFootEntity)

    @Query(
            """
            SELECT *
            FROM marcadorfootentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
        )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<MarcadorFootEntity>>

}