package com.tragulon.plants.screens.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tragulon.plants.screens.database.FavouriteDao
import com.tragulon.plants.screens.database.FavouriteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(var favouriteDao : FavouriteDao) : ViewModel() {

    val favourites: Flow<List<FavouriteEntity>> = favouriteDao.getAll()

    fun addToFavourites(imageResId: Int, title: String, screenName : String) {
        viewModelScope.launch {
            val favouriteEntity = FavouriteEntity(imageResId, title, screenName)
            favouriteDao.insertFavourite(favouriteEntity)
        }
    }

    fun removeFromFavourites(imageResId: Int, title: String, screenName : String) {
        viewModelScope.launch {
            favouriteDao.deleteFavourite(imageResId, title, screenName)
        }
    }
}