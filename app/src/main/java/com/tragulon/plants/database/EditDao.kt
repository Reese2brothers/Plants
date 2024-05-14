package com.tragulon.plants.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EditDao {
    @Query("SELECT * FROM editentity")
    fun getAll() : Flow<List<EditEntity>>
    @Insert
    suspend fun insertEdit(editEntity : EditEntity)
    @Query("DELETE FROM editentity")
    suspend fun deleteAll()
    @Update
    suspend fun updateEdit(editEntity: EditEntity)

}