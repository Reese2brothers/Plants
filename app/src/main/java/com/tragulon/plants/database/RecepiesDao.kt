package com.tragulon.plants.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecepiesDao {
    @Query("SELECT * FROM recepiesentity")
    fun getAll() : Flow<List<RecepiesEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecepies(recepiesEntity : RecepiesEntity)
    @Query("DELETE FROM recepiesentity")
    suspend fun deleteAll()
    @Delete
    suspend fun deleteRecepies(recepiesEntity: RecepiesEntity)
}