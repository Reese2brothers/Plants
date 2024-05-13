package com.tragulon.plants.screens.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Query("SELECT * FROM favouriteentity")
    fun getAll() : Flow<List<FavouriteEntity>>
    @Insert
    suspend fun insertFavourite(favouriteEntity : FavouriteEntity)
    @Query("DELETE FROM favouriteentity WHERE imageResId = :imageResId AND title = :title AND screenName = :screenName")
    suspend fun deleteFavourite(imageResId: Int, title: String, screenName : String)
}