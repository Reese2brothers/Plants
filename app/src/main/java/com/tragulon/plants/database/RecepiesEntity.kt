package com.tragulon.plants.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecepiesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title : String,
    val details : String
)