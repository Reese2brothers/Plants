package com.tragulon.plants.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EditEntity(
    val text : String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
