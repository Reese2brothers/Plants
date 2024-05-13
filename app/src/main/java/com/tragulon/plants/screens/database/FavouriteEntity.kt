package com.tragulon.plants.screens.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavouriteEntity (
    val imageResId: Int,
    val title : String,
    val screenName: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}