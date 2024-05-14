package com.tragulon.plants.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tragulon.plants.database.EditDao
import com.tragulon.plants.database.EditEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(var editDao : EditDao) : ViewModel(){

    val edits: Flow<List<EditEntity>> = editDao.getAll()
    fun addToEditEntity(text : String){
        viewModelScope.launch {
            editDao.deleteAll()
            editDao.insertEdit(EditEntity(text))
        }
    }
    fun loadInitialData(currentText: MutableState<String>) {
        viewModelScope.launch {
            edits.firstOrNull()?.let {
                if (it.isNotEmpty()) {
                    currentText.value = it.first().text
                }
            }
        }
    }
    fun updateText(text: String) {
        viewModelScope.launch {
            editDao.updateEdit(EditEntity(text))
        }
    }
}