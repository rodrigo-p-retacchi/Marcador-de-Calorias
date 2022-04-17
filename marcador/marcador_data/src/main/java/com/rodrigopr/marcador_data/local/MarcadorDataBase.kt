package com.rodrigopr.marcador_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodrigopr.marcador_data.local.entity.MarcadorFootEntity

@Database(
    entities = [MarcadorFootEntity::class],
    version = 1
)
abstract class MarcadorDataBase : RoomDatabase() {
    abstract val dao: MarcadorDao
}