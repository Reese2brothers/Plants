package com.tragulon.plants.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EditDao {
    @Query("SELECT * FROM editentity")
    fun getAll() : Flow<List<EditEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEdit(editEntity : EditEntity)
    @Query("DELETE FROM editentity")
    suspend fun deleteAll()

}