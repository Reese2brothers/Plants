package com.tragulon.plants.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tragulon.plants.database.RecepiesDao
import com.tragulon.plants.database.RecepiesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecepiesViewModel @Inject constructor(val recepiesDao: RecepiesDao) : ViewModel(){

    val recepies: Flow<List<RecepiesEntity>> = recepiesDao.getAll()

    fun insertOrUpdateRecepies(recepiesEntity : RecepiesEntity){
        viewModelScope.launch {
            recepiesDao.insertRecepies(recepiesEntity)
        }
    }
    fun deleteText(id : Int, title : String, details : String) {
        viewModelScope.launch {
            recepiesDao.deleteRecepies(RecepiesEntity(id, title, details))
        }
    }
}